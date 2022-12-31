package vecmatlib.matrix

import vecmatlib.vector.VecFloat

/**
 * Trait for matrices that can be converted to float.
 *
 * @tparam M The corresponding double matrix
 * @tparam V The corresponding double vector
 */
trait MatAsFloat[M <: MatFloat[M, V], V <: VecFloat[V]] {

  /**
   * Converts this matrix to a float matrix.
   *
   * @return This same matrix as a float matrix
   */
  def toFloat: M

  /**
   * Computes the sum between this matrix and the given one.
   *
   * @param m The matrix to add.
   * @return The sum of this matrix and the given one.
   */
  def +(m: M): M = this.toFloat + m

  /**
   * Computes the sum between this matrix and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum of this matrix and the given one.
   */
  def plus(m: M): M = this + m

  /**
   * Computes the subtraction between the given matrix and this one.
   *
   * @param m The matrix to subtract.
   * @return The subtraction of the given matrix from this one.
   */
  def -(m: M): M = this.toFloat - m

  /**
   * Computes the subtraction between the given matrix and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction of the given matrix from this one.
   */
  def minus(m: M): M = this - m

  /**
   * Returns the product between this matrix and the given scalar.
   *
   * @param k The scalar to which the matrix is multiplied.
   * @return The result of the product between this matrix and the given scalar.
   */
  def *(k: Float): M = this.toFloat * k

  /**
   * Returns the product between this matrix and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar to which the matrix is multiplied.
   * @return The result of the product between this matrix and the given scalar.
   */
  def multipliedBy(k: Float): M = this * k

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def *(v: V): V = this.toFloat * v

  /**
   * Returns the product of this matrix by the given vector.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def multiply(v: V): V = this * v

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def *(m: M): M = this.toFloat * m

  /**
   * Returns the product between this matrix and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def multiply(m: M): M = this * m
}
