
# VecMatLib

A Scala library for vectors and matrix math.

## Project goals

The goal of VecMatLib is to provide easy-to-use and efficient linear algebra operations.

Vectors and matrices structures are written in Scala to make the best use possible of Scala's operator overloading.
All methods with symbolic names have an alias for better interoperability with java.

All operations in VecMatLib are designed to **not** modify the object on which the operation is invoked to respect the principles of purity and immutability of functional programming.

## Vector math

The vector package offers 2-dimensional, 3-dimensional, and 4-dimensional vectors of type int, float, and double with all their basic operations.
All operations do not modify the vector on which the operation is performed.

Scala example:

```scala
var a = Vec3f(1.0f, 1.0f, 1.0f)
var b = Vec3f(0.5f, 0.5f, 0.5f)

// 'a' and 'b' will not change
val c = a + b

// Increase 'a' by 'b'
a = a + b

// Other operations
val dotProduct = a dot b
val normal = a.normalized
val reflection = b.reflect(normal)
```

Java example:

```java
Vec3f a = new Vec3f(1.0f, 1.0f, 1.0f);
Vec3f b = new Vec3f(0.5f, 0.5f, 0.5f);

// 'a' and 'b' will not change
Vec3f c = a.plus(b);

// Increase 'a' by 'b'
a = a.plus(b);

// Other operations
float dotProduct = a.dot(b);
Vec3f normal = a.normalized();
Vec3f reflection = b.reflect(normal);
```

## Matrix math

The matrix package offers 2x2, 3x3, and 4x4 matrices of type int, float, and double with all their basic operations as well as methods to build matrices out of basic transformations.
All operations do not modify the matrix on which the operation is performed.

The following example shows how a translation matrix is created and how the transformation is applied.

```scala
var position = Vec4f(x, y, z, 1.0f)
val translation = Mat4f.translation(tx, ty, tz)

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation * position
```

```java
Vec4f position = new Vec4f(x, y, z, 1.0f);
Mat4f translation = Mat4f.translation(tx, ty, tz);

// will result in (x + tx, y + ty, z + tz, 1.0f)
position = translation.multiply(position);
```

Matrices can be multiplied together, allowing to create more complex transformations.
The same pattern can be used to create projection matrices and camera view matrices.

```scala
val transform = Mat4f.translation(tx, ty, tz) * Mat4f.rotation(rx, ry, rz) * Mat4f.scaling(sx, sy, sz)
var point = Vec4f(x, y, z, 1.0f)

// Applies first a translation by (tx, ty, tz),
// then a rotation by (rx, ry, rz) in radians,
// then a scaling by (sx, sy, sz)
point = transform * point
```

```java
Mat4f transform = Mat4f.translation(tx, ty, tz)
        .multiply(Mat4f.rotation(rx, ry, rz))
        .multiply(Mat4f.scaling(sx, sy, sz));
Vec4f point = new Vec4f(x, y, z, 1.0f);

// Applies first a translation by (tx, ty, tz),
// then a rotation by (rx, ry, rz) in radians,
// then a scaling by (sx, sy, sz)
point = transform.multiply(point);
```

## Color math

VecMatLib also provides a structure to represent a color as four-dimensional or three-dimensional floating point tuples with values between 0.0 and 1.0.
Such representation of colors resembles the one used in the [OpenGL Shading Language](https://www.khronos.org/opengl/wiki/OpenGL_Shading_Language).

```scala
val white = Color3f(1.0f, 1.0f, 1.0f) // RGB #FFFFFF
val green = Color3f(0.0f, 1.0f, 0.0f) // RGB #00FF00
val transparentBlue = Color4f(0.0f, 0.0f, 1.0f, 0.5f) // RGBA #0000FF88
```

Values outside the (0.0, 1.0) range are allowed.

## Using with LWJGL

VecMatLib can be used together with [LWJGL](https://lwjgl.org) to set uniform variables in shaders.

This example first creates a 3D float vector, then loads the value into the active shader program.

```java
Vec3f lightPosition = new Vec3f(-3.0f, 10.0f, 6.0f);
int location = GL20.glGetUniformLocation(program, "light_position");
GL20.glUniform3f(location, lightPosition.x(), lightPosition.y(), lightPosition.z());
```

An LWJGL project using VecMatLib is [LWJRE](https://github.com/LWJRE), a general purpose rendering engine written in Java.

## Add VecMatLib to your project

### sbt

```
libraryDependencies += "io.github.hexagonnico" % "vecmatlib" % "2.2"
```

### Maven

```xml
<dependency>
    <groupId>io.github.hexagonnico</groupId>
    <artifactId>vecmatlib</artifactId>
    <version>2.2</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.hexagonnico:vecmatlib:2.2'
```

## Contributing

VecMatLib was developed by a single person.
Initially a university project, later completed and turned into a fully usable library.

Your contributions are always welcome! Please submit a pull request or open an issue if you want to contribute with bug fixes, code improvements, documentation, and better unit test coverage.
