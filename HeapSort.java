package _20010310064_Mehmet_Alptekin;

public class HeapSort {
	
	/*
	 YAZDIĞIMIZ CLASSLARIN YAPTIĞI İŞLER VE ÖZELLİKLERİ :
	 
	 Insert(Kayit kayit) -> kayit nesnesini T.C. kimlik no alanına göre veri yapısına ekler.

     Kayit Search(long T.C. kimlik no) -> T.C. kimlik no değeri verilen kaydı veri yapısında arar ve eğer
     bulursa kaydı döndürür, bulamazsa null döndürür.

     Kayit En_Buyuk_Kaydi_Cikar() -> En büyük T.C. kimlik no değerine sahip olan kaydı döndürür ve aynı
     zamanda bu kaydı veri yapısından siler. İşlem sonrası veri yapısı Max-heap özelliğini korumalıdır.

     Kayit Delete(long T.C. kimlik no) -> T.C. kimlik no değeri verilen kayit eğer veri yapısında varsa onu
     döndürür ve aynı zamanda bu kaydı veri yapısından siler, yoksa null döndürür. İşlem sonrası veri
     yapısı Max-heap özelliğini korumalıdır.

     Kayit Delete_pos(int pozisyon) -> Pozisyonu verilen kaydı döndürür ve aynı zamanda bu kaydı veri
     yapısından siler. Eğer pozisyon değeri heap-size sınırları içerisinde değilse null döndürür. İşlem
     sonrası veri yapısı Max-heap özelliğini korumalıdır.

     int Return_Kayit_Sayisi() -> Heap’te kaç tane kayıt olduğunu döndürür.

     int Return_Seviye_Sayisi() -> Heap ağacının seviye sayısını döndürür.

     Ekrana_Yazdir(Kayit kayit) -> kayit nesnesinin değerlerini(T.C. kimlik no, ad, soyad) ekrana yazdırır.

     void Resize() -> Veri yapısının boyutunu 2 katına çıkarır.
	  */
	
	
	
	

	int integerTC[];
	String StringDizi[];
	String AnaDizi[];
	int counter = 0;
	int size;
	int integerTCuzunluk;
	int uzunluk;
	
	public int parent(int x) {
		return (x - 1) / 2;
	}

	public int left(int x) {
		return (x * 2) + 1;
	}

	public int right(int x) {
		return (x * 2) + 2;
	}

	public void insert(String s) {
			StringDizi[counter] = s;

			integerTC[counter] = Integer.parseInt(s.substring(0, 9));

			counter++;
	}

	public void MaxHeapify(int x) {
		int largest = x;
		int r = right(x);
		int l = left(x);

		if (l < integerTC.length && integerTC[l] > integerTC[largest]) {
			largest = l;
		}

		if (r < integerTC.length && integerTC[r] > integerTC[largest]) {
			largest = r;
		}

		if (largest != x) {

			int temp;

			temp = integerTC[x];

			integerTC[x] = integerTC[largest];

			integerTC[largest] = temp;

			MaxHeapify(largest);
		}

	}

	public void BuildMaxHeap() {
		for (int counter = (integerTC.length - 1) / 2; counter >= 0; counter--) {
			MaxHeapify(counter);
		}
	}

	void KayitSearch(long i) {

		i = i / 10;
		boolean durum = false;
		for (int counter = 0; counter < integerTC.length; counter++) {
			if (i == integerTC[counter]) {
				System.out.println(AnaDizi[counter]);
				durum = true;
			}
		}
		if (durum == false) {
			System.out.println("null");
		}
	}

	void En_Buyuk_Kaydi_Cikar() {
		benimCozum();

		System.out.print(AnaDizi[0]);

		int temp = integerTC[0];
		integerTC[0] = integerTC[integerTC.length - 1];
		integerTC[integerTC.length - 1] = temp;
		integerTCuzunluk = integerTC.length - 2;
		BuildMaxHeap();
		uzunluk = AnaDizi.length - 1;
		benimCozum();
	}

	void Kayit_Delete(long sil) {

		sil = sil / 10;
		boolean durum = false;
		for (int counter = 0; counter <= integerTC.length; counter++) {
			if (integerTC[counter] == sil) {
				durum = true;
				benimCozum();
				System.out.println(AnaDizi[counter]);
				int temp = integerTC[counter];
				integerTC[counter] = integerTC[integerTC.length - 1];
				integerTC[integerTC.length - 1] = temp;
				integerTCuzunluk = integerTC.length - 2;
				uzunluk = AnaDizi.length - 1;
				BuildMaxHeap();
				benimCozum();
				break;
			}
		}
		if (durum == false) {
			System.out.println("null");
		}

	}

	void Delete_Pos(int pos) {

		System.out.println(AnaDizi[pos]);

		int temp = integerTC[pos];
		integerTC[pos] = integerTC[integerTC.length - 1];
		integerTC[integerTC.length - 1] = temp;
		integerTCuzunluk = integerTC.length - 2;
		BuildMaxHeap();
		uzunluk = AnaDizi.length - 1;
		benimCozum();
	}

	int Kayit_Sayisi() {
		return integerTC.length;
	}

	int Seviye_Sayisi() {
		int height = (int) Math.floor(Math.log(integerTC.length) / Math.log(2)) + 1;
		return height;
	}

	void Resize() {
		size = size*2;
	}

	public void benimCozum() {
		String temp2[] = new String[size];

		for (int counter = 0; counter < integerTC.length; counter++) {

			temp2[counter] = Integer.toString(integerTC[counter]);
		}

		for (int counter2 = 0; counter2 < integerTC.length; counter2++) {
			for (int counter3 = 0; counter3 < integerTC.length; counter3++) {

				if (StringDizi[counter3].substring(0, 9).equals(temp2[counter2].substring(0, 9))) {
					AnaDizi[counter2] = StringDizi[counter3];
				}
			}
		}

	}

	public void Print() {
		  System.out.println();
		  for (int counter = 0; counter <AnaDizi.length; counter++) {
		  System.out.println(AnaDizi[counter]); }  
	}

}
