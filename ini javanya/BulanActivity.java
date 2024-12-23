package com.example.kalender_ilham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class BulanActivity extends AppCompatActivity {

    private Spinner spinnerBulan;
    private TextView outputHasil;
    private Button buttonCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulan);

        // Inisialisasi View
        spinnerBulan = findViewById(R.id.spinner_bulan);
        outputHasil = findViewById(R.id.output);
        buttonCari = findViewById(R.id.button_cari_data);

        // Data untuk Spinner (Daftar bulan)
        String[] bulanArray = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bulanArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBulan.setAdapter(adapter);

        // Data tanggal merah (hari libur)
        HashMap<String, String> tanggalMerah = new HashMap<>();
        tanggalMerah.put("Januari", "1 Januari - Tahun Baru\n22 Januari - Tahun Baru Imlek");
        tanggalMerah.put("Februari", "Tidak ada tanggal merah");
        tanggalMerah.put("Maret", "22 Maret - Nyepi");
        tanggalMerah.put("April", "7 April - Wafat Isa Almasih");
        tanggalMerah.put("Mei", "1 Mei - Hari Buruh\n18 Mei - Kenaikan Isa Almasih\n19 Mei - Hari Raya Waisak");
        tanggalMerah.put("Juni", "1 Juni - Hari Lahir Pancasila");
        tanggalMerah.put("Juli", "Tidak ada tanggal merah");
        tanggalMerah.put("Agustus", "17 Agustus - Hari Kemerdekaan");
        tanggalMerah.put("September", "Tidak ada tanggal merah");
        tanggalMerah.put("Oktober", "Tidak ada tanggal merah");
        tanggalMerah.put("November", "Tidak ada tanggal merah");
        tanggalMerah.put("Desember", "25 Desember - Hari Natal");

        // Aksi tombol "CARI DATA"
        buttonCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bulanDipilih = spinnerBulan.getSelectedItem().toString(); // Ambil bulan dari Spinner
                String hasil = tanggalMerah.getOrDefault(bulanDipilih, "Tidak ada data tanggal merah");
                outputHasil.setText(hasil); // Tampilkan hasil pencarian
            }
        });

        TextView tahun = findViewById(R.id.tahun);
        tahun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BulanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
