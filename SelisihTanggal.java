import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SelisihTanggal {
    public static void main(String[] args) {

        String stglAwal;
        String stglAkhir;
        Scanner keyboard = new Scanner(System.in);
        DateFormat dateAwal = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateAkhir = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("===Penghitungan Hari Antara 2 Tanggal===");
        System.out.println("    **Format Masukkan (dd/MM/yyyy)**    ");
        System.out.print("Tanggal Awal  : "); stglAwal = keyboard.nextLine();
        System.out.print("Tanggal Akhir : "); stglAkhir = keyboard.nextLine();

        try {
            Date tglAwal = dateAwal.parse(stglAwal);
            Date tglAkhir = dateAkhir.parse(stglAkhir);

            Date TGLAwal = tglAwal;
            Date TGLAkhir = tglAkhir;
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(TGLAwal);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(TGLAkhir);

            String hasil = String.valueOf(daysBetween(cal1, cal2));
            System.out.println("=============================");
            System.out.println("Tanggal Awal  = " +stglAwal);
            System.out.println("Tanggal Akhir = " +stglAkhir);
            System.out.println("Hasil : " +hasil+ " hari");
            System.out.println("=============================");
        } catch (ParseException e) {
        }
    }

    private static long daysBetween(Calendar tanggalAwal, Calendar tanggalAkhir) {
        long lama = 0;
        Calendar tanggal = (Calendar) tanggalAwal.clone();
        while (tanggal.before(tanggalAkhir)) {
            tanggal.add(Calendar.DAY_OF_MONTH, 1);
            lama++;
        }
        return lama;
    }
}
