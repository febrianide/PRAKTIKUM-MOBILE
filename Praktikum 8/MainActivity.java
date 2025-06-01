package com.example.aplikasilistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listViewJadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewJadwal = findViewById(R.id.listViewJadwal);

        // Jadwal lengkap
        String[] jadwal = {
                "Senin - 07:00 - Matematika",
                "Senin - 09:00 - Fisika",
                "Selasa - 08:00 - Bahasa Inggris",
                "Selasa - 10:00 - Praktikum Komputer",
                "Rabu - 07:00 - Biologi",
                "Rabu - 09:00 - Seni Budaya",
                "Kamis - 08:00 - IPS",
                "Kamis - 10:00 - Bahasa Indonesia",
                "Jumat - 07:30 - Olahraga",
                "Jumat - 10:00 - PKN",
                "Sabtu - 08:00 - Ekstrakurikuler Musik",
                "Sabtu - 10:00 - Ekstrakurikuler Pramuka",
                "Sabtu - 14:00 - Rapat OSIS",
                "Sabtu - 16:00 - Rapat Organisasi",
                "Minggu - 09:00 - Persiapan Lomba Sains"
        };

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                jadwal
        );

        listViewJadwal.setAdapter(adapter);
    }
}

