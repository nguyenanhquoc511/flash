package quoc5;

public class rational {

	public int numerator, denominator;

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	rational(){
		this.denominator = 1;
		this.numerator = 0;
	}
	
	rational(int numerator, int denominator){
		this.denominator = denominator;
		this.numerator = numerator;
	}
	
	int ucln(int a , int b) {
		int tmp;
		while(b > 0) {
			a = a % b;
			tmp = a;
			a = b;
			b = tmp;
		}
		return a;
	}
	
	void redure() {
		int tmp = ucln(this.numerator, this.denominator);
		this.numerator /= tmp ;
		this.denominator /= tmp;
	}
	
	void reciprocal() {
		int tmp;
		tmp = this.numerator;
		this.numerator = this.denominator;
		
		 
		this.denominator = tmp;
	}
	
	void add(rational k) {
		this.numerator = this.numerator*k.denominator + this.denominator*k.numerator;
		this.denominator *= k.denominator;
		redure();
	}
	
	void subtract(rational k) {
		this.numerator = this.numerator*k.denominator - this.denominator*k.numerator;
		this.denominator *= k.denominator;
		redure();
	}
	
	void multiply(rational k) {
		this.numerator *= k.numerator;
		this.denominator *= k.denominator;
		redure();
	}
	
	void divide(rational k) {
		this.numerator *= k.denominator;
		this.denominator *= k.numerator;
		redure();
	}
	
	void compare(rational k) {
		float tmp1 = (float)this.numerator/this.denominator;
		float tmp2 = k.numerator/k.denominator;
		if (tmp1 > tmp2) 
			System.out.print(this.numerator + "/" + this.denominator+ ">" +k.numerator+ "/"+ k.denominator);
		else
			if (tmp1 == tmp2)
				System.out.print(this.numerator + "/" + this.denominator+ "=" +k.numerator+ "/"+ k.denominator);
			else
				System.out.print(this.numerator + "/" + this.denominator+ "<" +k.numerator+ "/"+ k.denominator);

	}
	
	void output() {
		System.out.println(this.numerator+ "/" + this.denominator);
	}
}
	