package vecmatlib.vector

import vecmatlib.Double3

/**
 * Three-dimensional double vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 */
case class Vec3d(x: Double, y: Double, z: Double) extends Double3 with VecDouble[Vec3d] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x + x, this.y + y, this.z + z)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Double, y: Double, z: Double): Vec3d = this + (x, y, z)

  override def +(v: Vec3d): Vec3d = this + (v.x, v.y, v.z)

  override def unary_- : Vec3d = Vec3d(-this.x, -this.y, -this.z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one
   */
  def -(x: Double, y: Double, z: Double): Vec3d = this + (-x, -y, -z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one
   */
  def minus(x: Double, y: Double, z: Double): Vec3d = this - (x, y, z)

  override def *(k: Double): Vec3d = Vec3d(this.x * k, this.y * k, this.z * k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars
   */
  def *(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x * x, this.y * y, this.z * z)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars
   */
  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  override def *(v: Vec3d): Vec3d = this * (v.x, v.y, v.z)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components
   */
  def dot(x: Double, y: Double, z: Double): Double = this.x * x + this.y * y + this.z * z

  override def dot(v: Vec3d): Double = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product (or vector product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The cross product between this vector and the one with the given components
   */
  def cross(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product (or vector product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The cross product between this vector and the given one
   */
  def cross(v: Vec3d): Vec3d = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product (or vector product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The cross product between this vector and the given one.
   */
  def cross(v: VecAsDouble[Vec3d]): Vec3d = this cross v.toDouble

  override def lengthSquared: Double = this dot this

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec3i = Vec3i(this.x.toInt, this.y.toInt, this.z.toInt)

  /**
   * Casts this vector to a float vector.
   *
   * @return A vector same as this one cast to float
   */
  def toFloat: Vec3f = Vec3f(this.x.toFloat, this.y.toFloat, this.z.toFloat)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Double, y: Double, z: Double): Boolean = this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Double, y: Double, z: Double): Boolean = this == (x, y, z)
}

object Vec3d {
  /** Shorthand for `new Vec3d(0.0, 0.0, 0.0)` */
  val Zero: Vec3d = Vec3d(0.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(1.0, 1.0, 1.0)` */
  val One: Vec3d = Vec3d(1.0, 1.0, 1.0)
  /** Shorthand for `new Vec3d(1.0, 0.0, 0.0)` */
  val Right: Vec3d = Vec3d(1.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(-1.0, 0.0, 0.0)` */
  val Left: Vec3d = Vec3d(-1.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, 1.0, 0.0)` */
  val Up: Vec3d = Vec3d(0.0, 1.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, -1.0, 0.0)` */
  val Down: Vec3d = Vec3d(0.0, -1.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, 0.0, 1.0)` */
  val Forward: Vec3d = Vec3d(0.0, 0.0, 1.0)
  /** Shorthand for `new Vec3d(0.0, 0.0, -1.0)` */
  val Backwards: Vec3d = Vec3d(0.0, 0.0, -1.0)
}
