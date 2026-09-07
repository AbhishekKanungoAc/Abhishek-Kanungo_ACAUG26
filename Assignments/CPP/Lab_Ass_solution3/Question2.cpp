#include <iostream>
#include <memory>
#include <string>

using namespace std;

// ============================================================
// PART A : unique_ptr
// Texture has EXCLUSIVE ownership
// ============================================================

class Texture
{
private:
    string name;
    int width;
    int height;

public:
    // Constructor
    Texture(string n, int w, int h)
    {
        name = n;
        width = w;
        height = h;

        cout << "[Texture Loaded]" << endl;
    }

    // Destructor
    ~Texture()
    {
        cout << "[Texture Released]" << endl;
    }

    // Display texture dimensions
    void display() const
    {
        cout << "Texture: " << name << endl;
        cout << "Dimensions: " << width << " x " << height << endl;
    }
};

// ============================================================
// PART B : shared_ptr
// Shader can have MULTIPLE owners
// ============================================================

class Shader
{
private:
    string name;
    string type;

public:
    // Constructor
    Shader(string n, string t)
    {
        name = n;
        type = t;

        cout << "[Shader Compiled]" << endl;
    }

    // Destructor
    ~Shader()
    {
        cout << "[Shader Destroyed]" << endl;
    }

    // Returns the reference count of a shared_ptr
    //
    // shared_ptr is passed as a parameter.
    // use_count() tells us how many shared_ptr objects
    // currently share ownership of the same Shader.
    int getReferenceCount(const shared_ptr<Shader> &ptr)
    {
        return ptr.use_count();
    }
};

// ============================================================
// PART C : weak_ptr
// AudioClip is owned by shared_ptr.
// Event system only OBSERVES it using weak_ptr.
// ============================================================

class AudioClip
{
private:
    string name;
    double duration;

public:
    // Constructor
    AudioClip(string n, double d)
    {
        name = n;
        duration = d;

        cout << "[AudioClip Loaded]" << endl;
    }

    // Destructor
    ~AudioClip()
    {
        cout << "[AudioClip Released]" << endl;
    }

    // Return audio clip name
    string getName() const
    {
        return name;
    }

    // Display audio information
    void display() const
    {
        cout << "Audio: " << name << endl;
        cout << "Duration: " << duration << " seconds" << endl;
    }
};

// ============================================================
// MAIN FUNCTION
// ============================================================

int main()
{
    cout << "========== PART A : unique_ptr ==========" << endl;

    // make_unique creates a Texture dynamically
    // and gives ownership to tex1.
    //
    // unique_ptr means ONLY ONE unique_ptr can own
    // this Texture at a time.
    auto tex1 = make_unique<Texture>(
        "player_sprite",
        512,
        512);

    // Access object through unique_ptr using ->
    tex1->display();

    // --------------------------------------------------------
    // Attempting to COPY a unique_ptr
    // --------------------------------------------------------

    // unique_ptr<Texture> tex2 = tex1;

    // ERROR!
    //
    // unique_ptr cannot be copied because it allows
    // only ONE owner.
    //
    // If copying were allowed, two unique_ptr objects
    // would try to delete the same object.

    // --------------------------------------------------------
    // TRANSFER ownership using move()
    // --------------------------------------------------------

    // Ownership is transferred from tex1 to tex2.
    unique_ptr<Texture> tex2 = move(tex1);

    // After move(), tex1 no longer owns the Texture.
    // Therefore tex1 becomes nullptr.
    cout << "tex1 is null: "
         << (tex1 == nullptr ? "YES" : "NO")
         << endl;

    // tex2 is now the owner.
    tex2->display();

    // --------------------------------------------------------
    // tex2 will automatically release the Texture
    // when it goes out of scope at the end of main.
    // --------------------------------------------------------

    cout << endl;

    cout << "========== PART B : shared_ptr ==========" << endl;

    // Create Shader using make_shared.
    //
    // Initially only 'shader' owns the object.
    // Therefore reference count = 1.
    auto shader = make_shared<Shader>(
        "main_vert",
        "vertex");

    cout << "Ref count: "
         << shader.use_count()
         << endl; // 1

    // Create another shared_ptr.
    //
    // rendererRef and shader now share ownership.
    {
        auto rendererRef = shader;

        cout << "Ref count: "
             << shader.use_count()
             << endl; // 2

        // Another shared_ptr shares the same Shader.
        // Now shader, rendererRef and editorRef
        // all own the same object.
        auto editorRef = shader;

        cout << "Ref count: "
             << shader.use_count()
             << endl; // 3
    }

    // The block has ended.
    //
    // rendererRef and editorRef are destroyed automatically.
    // Only 'shader' remains.
    //
    // Therefore reference count becomes 1 again.
    cout << "Ref count: "
         << shader.use_count()
         << endl; // 1

    cout << endl;

    cout << "========== PART C : weak_ptr ==========" << endl;

    // Create AudioClip using shared_ptr.
    //
    // 'audio' is the owner of the AudioClip.
    auto audio = make_shared<AudioClip>(
        "explosion",
        3.5);

    // weak_ptr observes the AudioClip.
    //
    // IMPORTANT:
    // weak_ptr DOES NOT own the object.
    // Therefore it does NOT increase shared_ptr's
    // reference count.
    weak_ptr<AudioClip> observer = audio;

    // --------------------------------------------------------
    // Check whether AudioClip is still alive
    // --------------------------------------------------------

    // lock() tries to convert weak_ptr into shared_ptr.
    //
    // If object is alive:
    //     clip contains a valid shared_ptr.
    //
    // If object is destroyed:
    //     clip becomes empty.
    if (auto clip = observer.lock())
    {
        cout << "Clip alive: "
             << clip->getName()
             << endl;
    }

    // --------------------------------------------------------
    // Unload the AudioClip
    // --------------------------------------------------------

    // reset() releases audio's ownership.
    //
    // There are no other shared_ptr owners.
    // Therefore AudioClip is destroyed.
    audio.reset();

    // --------------------------------------------------------
    // Check again after unloading
    // --------------------------------------------------------

    // expired() returns true when the object being observed
    // by weak_ptr no longer exists.
    if (observer.expired())
    {
        cout << "Clip already unloaded." << endl;
    }

    return 0;
}