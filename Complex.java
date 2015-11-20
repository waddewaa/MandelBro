
public class Complex {

	private double re;
	private double im;

	/** Skapar en komplex variabel med realdelen re och imaginärdelen im */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/** Tar reda på realdelen */
	public double getRe() {
		return re;
	}

	/** Tar reda på imaginärdelen */
	public double getIm() {
		return im;
	}

	/** Tar reda på talets absolutbelopp i kvadrat */
	public double getAbs2() {
		return (re * re + im * im);
	}

	/** Adderar det komplexa talet c till detta tal */
	public void add(Complex c) {
		re += c.re;
		im += c.im;
	}

	/** Multiplicerar detta tal med det komplexa talet c */
	void mul(Complex c) {
		double tempRe = this.re;
		double tempIm = this.im;
		double a = c.re;
		double b = c.im;

		re = a * tempRe - b * tempIm;
		im = a * tempIm + tempRe * b;

	}

}
