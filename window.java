
import java.awt.Color;
//import se.lth.cs.pt.fractal.MandelbrotGUI;
/** First generates a set color templete depending on n iterations, then tries each
 * pixel/point in the window for n iterations and sees if they're still in the Mandelbrot set,
 * and if not, gives it different colors depending on how fast i diverts from the set.
 * @author william
 *
 */
public class Genertaor {
	/**
	 * Returns a Color[width][height] in the interval between minRe, maxRe, minIm and maxIm.
	 * Returns a black&white array if bool = true, else a colorfull one.
	 * @param width
	 * @param height
	 * @param minRe
	 * @param maxRe
	 * @param minIm
	 * @param maxIm
	 * @param bool
	 * @return
	 */
	// ritar en bild i fönstret i användargränssnittet gui
	public Color[][] render(int width, int height,
							double minRe, double maxRe,
							double minIm, double maxIm,
							boolean bool) {
		
		
		
		
		//anropa dissableInput i MandelbrotGui
//		gui.disableInput();
//		Scanner scan = new Scanner(gui.getExtraText());
//		
//		int iter =1020;
//		int res = 1;
//		try{
//			iter = scan.nextInt();
//		}catch(Exception err){
//			
//		}
//		
//		scan.close();
//		switch(gui.getResolution()){
//		
//		case 2048:
//			res = 1;
//			break;
//			
//		case 1024:
//			res = 3;
//			break;
//			
//		case 512:
//			res = 5;
//			break;
//			
//		case 256:
//			res = 7;
//			break;
//		
//		case 128:
//			res = 9;
//			break;
//		
//		}
		// 2 anropa mesh för att skapa matrisen med komplexa tal, kalla matrisen complex.
		Complex[][] complex = new Complex[height][width];
		
		complex = mesh( minRe, maxRe, //re
					   minIm, maxIm, //im
					   height, width);

		// 3 deklarera matrisen Color[][] picture matrisen ska vara lika stor som ritytan.
		Color[][] picture = new Color[height][width];
		
		//4 gå igenom matrisen picture rad för rad och fyll i färg
		Color[] bAndW = new Color[255];
		Color[] color = new Color[1020];
		
		for (int q = 0; q < 255; q++){
			bAndW[q] = new Color(255 - q/2, 255 - q/2, 255 - q/2);
		}
			
			
		for(int f = 0; f < 255; f++){
					color[f] = new Color(f, 0, 255 - f);
				}

		for(int f = 255; f < 510; f++){
					color[f] = new Color(f - 255, 510 - f, 0);
				}
		
		for(int f = 510; f < 765; f++){
					color[f] = new Color(0, f - 510 ,  765 - f);
				}
		
		for(int f = 765; f < 1020; f++){
					color[f] = new Color(f - 765, 1020 - f, f - 765);
				}
		
		
		
		
		for (int i = 0; i < height; i ++){
			for (int k = 0; k < width; k++){
				Complex temp = new Complex(complex[i][k].getRe(), complex[i][k].getIm());
				int f = 0;
				for(int j = 0; j < 1500; j++){
					complex[i][k].mul(complex[i][k]);
					complex[i][k].add(temp);				
					f++;
					
					if (complex[i][k].getAbs2() > 4){
						break;
					}

				}
				if(complex[i][k].getAbs2() < 4){
					picture[i][k] = Color.black;
				}
				else if(bool){
					picture[i][k] = bAndW[254%f];
				} 
				else{
					picture[i][k] = color[1019%(f)];
					
				}
			}
		}
		
		
		
		
	

		
		
		//5 när varje element har fått en färg ska bilden ritas med putData i MandelbrotGui
		//gui.putData(picture);
		return picture;
		// 6 anropa enableInput för att återställa funktionen i gui.
		//gui.enableInput();
	}

	/**
	 * skapar en matris där varje element är ett komplext tal som har rätt
	 * kordinater
	 */
	private Complex[][] mesh(double minRe, double maxRe,
							 double minIm, double maxIm,
							 int height, int width) {

		Complex[][] complex = new Complex[height][width];

		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				complex[i][k] = new Complex(((maxRe - minRe) / (width - 1) * k) * 1 + minRe, 
											(maxIm - ((maxIm - minIm) / (height - 1)) * i));
			}

		}

		return complex;
	}
}
