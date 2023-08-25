package _20010310064_Mehmet_Alptekin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws FileNotFoundException {
		
		/* 
		  Java dilini kullanarak bir MAX-HEAP veri yapısını geliştirdik. 
		  Bir text dosyasında bulunan kayıtların ilk 5000 tanesini (önce ilk 2500, sonra ikinci 2500) okutup,
		  bu kayıtları MaxHeap veri yapısında organize edildi.           
		*/
		int size = 5000;
		int counter = 0;

		HeapSort heapSort = new HeapSort();
		String[] ilkStringDizi = new String[size];
		int[] ilkintegerTC = new int[size];
		String[] ilkAnaDizi = new String[size];
		heapSort.integerTC=ilkintegerTC;
		heapSort.StringDizi=ilkStringDizi;
		heapSort.AnaDizi=ilkAnaDizi;
		heapSort.size=size;
		
		
		File metin = new File("C:\\Users\\MedBim\\Desktop\\kayit_dosyasi.txt");
		
		Scanner input = new Scanner(metin);
		
		while (input.hasNext()) {
			if (counter==5000) {
				break;
			}
			
			String s = input.next();
			heapSort.insert(s); 
			counter++;
		}
		
		System.err.print("KAYIT SAYISI:  ");
		System.out.print(heapSort.Kayit_Sayisi());
		System.out.println();
		System.err.print("SILINEN DEGER:  ");
		heapSort.Kayit_Delete(7756591263L); 
		System.err.print("KAYIT SAYISI:  ");
		System.out.print(heapSort.Kayit_Sayisi());
		System.out.println();
		System.err.print("\nEN BUYUK KAYIT :  ");
		heapSort.En_Buyuk_Kaydi_Cikar();
		System.out.println();
		System.err.print("43. KAYDI SIL :  ");
		heapSort.Delete_Pos(43);
		System.out.println();
		System.err.print("ARANAN KAYIT :  ");
		heapSort.KayitSearch(9377761894L);
		System.out.println();
		System.out.print("SEVIYE SAYISI : "+heapSort.Seviye_Sayisi());
		//heapSort.benimCozum();
		//heapSort.BuildMaxHeap();
		//heapSort.Print();
		
		
	}

}
