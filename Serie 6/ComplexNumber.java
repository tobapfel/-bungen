
public class ComplexNumber {
	private double re, im;
	
	/**
	 * Creates a new Complex Number to zero.
	 */
	public ComplexNumber(){
		re = 0;
		im = 0;
	}
	
	/**
	 * Creates a new Complex Number.
	 * @param real value
	 * @param imaginary value
	 */
	public ComplexNumber(double real, double imaginary){
		re = real;
		im = imaginary;
	}
	
	/**
	 * Creates a Complex Number von cn.
	 * @param cn
	 */
	public ComplexNumber (ComplexNumber cn){
		re = cn.re;
		im = cn.im;
	}
	
	/**
	 * Return the real Value from Complex Number.
	 * @return Real Value 
	 */
	public double getReal(){
		return this.re;
	}
	
	/**
	 * Return the imaginary Value from Complex Number.
	 * @return Imaginary Value
	 */
	public double getImaginary(){
		return this.im;
	}
	
	/**
	 * conjugate a Complex Number.
	 * @return new Complex Number
	 */
	public ComplexNumber conjugate(){
		return new ComplexNumber(this.re, this.im*(-1));
	}
	
	/**
	 * returns a new complex number which is the sum of the two.
	 * @param other 2nd complex number
	 * @return sum of complex numbers
	 */
	public ComplexNumber add(ComplexNumber other){
		return new ComplexNumber (this.re + other.re, this.im + other.im);
	}
	
	/**
	 * returns a new complex number which is the result of subtracting ({@code other}) from the current complex number.
	 * @param other
	 * @return new complex number
	 */
	public ComplexNumber subtract(ComplexNumber other){
		return new ComplexNumber (this.re - other.re, this.im - other.im);
	}
	
	/**
	 * returns a new complex number which is the product of the two.
	 * @param other
	 * @return new complex number
	 */
	public ComplexNumber multiply(ComplexNumber other){
		return new ComplexNumber (((this.re*other.re) - (this.im*other.im)),((this.re*other.im) + (this.im*other.re)));
	}
	
	/**
	 * returns a new complex number which is the result of dividing the current complex number by the {@code other} one. 
	 * @param other
	 * @return {@code null} if {@code other} is 0 or a new complex number.
	 */
	public ComplexNumber divide(ComplexNumber other){
		if (other.re == 0 && other.im == 0){
			return null;
		}
		else{
			return new ComplexNumber ((this.re*other.re+this.im*other.im)/(Math.pow(other.re, 2) + Math.pow(other.im, 2)),
										((this.im*other.re)-(this.re*other.im))/(Math.pow(other.re, 2) + Math.pow(other.im, 2)));
		}
	}
	
	/**
	 * returns a double that is the absolute value of the complex number.
	 * @return
	 */
	public double abs(){
		return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
		}
	
	/**
	 * returns the Complex Number as a String
	 * @return a string
	 */
	public String toString(){
		String st = "";
		if (this.im <0){
			st = "" + this.re + " - " + Math.abs(this.im) + "i";
			return st; 
		}
		else {
			st = "" + this.re + " + " + this.im + "i";
			return st;
		}
	}
}


