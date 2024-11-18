package br.unipar.dicainvest

// Importa as bibliotecas necessárias para o funcionamento do aplicativo
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.PolylineOptions
import android.graphics.Color

class Map : AppCompatActivity(), OnMapReadyCallback {

    // Declara a variável do GoogleMap
    private lateinit var mMap: GoogleMap

    // Declara o cliente de localização para obter a localização do usuário
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps) // Define o layout da atividade

        // Inicializa o cliente de localização
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Configura o fragmento do mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // Prepara o mapa para ser usado
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap // Inicializa o mapa

        // Verifica se as permissões de localização foram concedidas
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Solicita as permissões de localização se não estiverem concedidas
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            return
        }

        // Ativa a funcionalidade de mostrar a localização atual no mapa
        mMap.isMyLocationEnabled = true

        // Obtém a localização atual do usuário
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                // Define a localização atual como LatLng
                val currentLocation = LatLng(location.latitude, location.longitude)

                // Adiciona um marcador na localização atual
                mMap.addMarker(MarkerOptions().position(currentLocation).title("Você está aqui"))

                // Move a câmera para a localização atual com zoom
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
            }
        }
    }

    // Exemplo de como traçar rotas usando Polyline
    private fun drawRoute(points: List<LatLng>) {
        // Configura as opções de Polyline, como largura e cor
        val options = PolylineOptions().width(10f).color(Color.BLUE)

        // Adiciona cada ponto da rota à Polyline
        for (point in points) {
            options.add(point)
        }

        // Adiciona a Polyline ao mapa
        mMap.addPolyline(options)
        }
}