package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import kz.cifron.vetqyzmet_doctor.registerAnimal.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityCameraBinding
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera.result.ResultActivity
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.Executor

private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss"

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    private lateinit var cameraExecutor: Executor
    private var imageCapture: ImageCapture? = null
    private val name =
        SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis())

    private val launcher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map.values.all { it }) {
                startCamera()
            } else {
                Toast.makeText(this, "Permission is not granted", Toast.LENGTH_SHORT).show()
            }
        }

    private val galleryLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                galleryNavigation(uri)
            }
        }

    private var receivedTask: Tasks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cameraExecutor = ContextCompat.getMainExecutor(this)

        binding.imageCaptureButton.setOnClickListener {
            takePhoto()
        }

        binding.btnGallery.setOnClickListener {
            openGallery()
        }

        binding.arrowBackBtn.setOnClickListener {
            finish()
        }

        val task = intent.getParcelableExtra<Tasks>("task")
        receivedTask = task

        startCamera()
        checkPermission()
    }

    private fun takePhoto() {
        val imageCapture = imageCapture ?: return
        val contentResolver = contentResolver

        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(
                contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            .build()

        imageCapture.takePicture(
            outputOptions,
            cameraExecutor,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    Toast.makeText(
                        this@CameraActivity,
                        "Photo saved on ${outputFileResults.savedUri}",
                        Toast.LENGTH_SHORT
                    ).show()

                    val imageUri = outputFileResults.savedUri
                    val bundle = Bundle()
                    bundle.putString("imageUri", imageUri.toString())
                    bundle.putParcelable("task", receivedTask)

                    val imageIntent = Intent(this@CameraActivity, ResultActivity::class.java)

                    val saveType = intent.getStringExtra("saveType")
                    val birthDateText = intent.getStringExtra("birthDateText")
                    val saveBreed = intent.getStringExtra("saveBreed")
                    val genderAnimal = intent.getStringExtra("genderAnimal")
                    val emailEt1 = intent.getStringExtra("emailEt1")
                    val saveColor = intent.getStringExtra("saveColor")
                    imageIntent.putExtra("saveTypeResult", saveType)
                    imageIntent.putExtra("birthDateTextResult", birthDateText)
                    imageIntent.putExtra("saveBreedResult", saveBreed)
                    imageIntent.putExtra("genderAnimalResult", genderAnimal)
                    imageIntent.putExtra("emailEt1Result", emailEt1)
                    imageIntent.putExtra("saveColorResult", saveColor)
                    val saveTypeReset = intent.getStringExtra("saveTypeResult")
                    val birthDateTextReset = intent.getStringExtra("birthDateTextResult")
                    val saveBreedReset = intent.getStringExtra("saveBreedResult")
                    val genderAnimalReset = intent.getStringExtra("genderAnimalResult")
                    val emailEt1Reset = intent.getStringExtra("emailEt1Result")
                    val saveColorReset = intent.getStringExtra("saveColorResult")
                    imageIntent.putExtra("saveTypeResultReset", saveTypeReset)
                    imageIntent.putExtra("birthDateTextResultReset", birthDateTextReset)
                    imageIntent.putExtra("saveBreedResultReset", saveBreedReset)
                    imageIntent.putExtra("genderAnimalResultReset", genderAnimalReset)
                    imageIntent.putExtra("emailEt1ResultReset", emailEt1Reset)
                    imageIntent.putExtra("saveColorResultReset", saveColorReset)


                    imageIntent.putExtras(bundle)
                    startActivity(imageIntent)
                    finish()
                }

                override fun onError(exception: ImageCaptureException) {
                    Toast.makeText(
                        this@CameraActivity,
                        "Photo failed: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    exception.printStackTrace()
                }
            }
        )
    }

    private fun galleryNavigation(outputFileResults: Uri) {
        val bundle = Bundle()
        bundle.putString("imageUri", outputFileResults.toString())
        bundle.putParcelable("task", receivedTask)

        val resultIntent = Intent(this@CameraActivity, ResultActivity::class.java)

        val saveType = intent.getStringExtra("saveType")
        val birthDateText = intent.getStringExtra("birthDateText")
        val saveBreed = intent.getStringExtra("saveBreed")
        val genderAnimal = intent.getStringExtra("genderAnimal")
        val emailEt1 = intent.getStringExtra("emailEt1")
        val saveColor = intent.getStringExtra("saveColor")
        // Вместо простого startActivity используйте setResult и finish

        resultIntent.putExtra("saveTypeResult", saveType)
        resultIntent.putExtra("emailEt1Result", emailEt1)
        resultIntent.putExtra("genderAnimalResult", genderAnimal)
        resultIntent.putExtra("saveBreedResult", saveBreed)
        resultIntent.putExtra("birthDateTextResult", birthDateText)
        resultIntent.putExtra("saveColorResult", saveColor)

        val saveTypeReset = intent.getStringExtra("saveTypeResult")
        val birthDateTextReset = intent.getStringExtra("birthDateTextResult")
        val saveBreedReset = intent.getStringExtra("saveBreedResult")
        val genderAnimalReset = intent.getStringExtra("genderAnimalResult")
        val emailEt1Reset = intent.getStringExtra("emailEt1Result")
        val saveColorReset = intent.getStringExtra("saveColorResult")

        resultIntent.putExtra("saveTypeResultReset", saveTypeReset)
        resultIntent.putExtra("birthDateTextResultReset", birthDateTextReset)
        resultIntent.putExtra("saveBreedResultReset", saveBreedReset)
        resultIntent.putExtra("genderAnimalResultReset", genderAnimalReset)
        resultIntent.putExtra("emailEt1ResultReset", emailEt1Reset)
        resultIntent.putExtra("saveColorResultReset", saveColorReset)

        setResult(RESULT_OK, resultIntent)
        finish()

//        resultIntent.putExtras(bundle)
//        startActivity(resultIntent)
//        finish()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(binding.viewFinder.surfaceProvider)
            imageCapture = ImageCapture.Builder().build()

            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                this,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageCapture
            )
        }, cameraExecutor)
    }

    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }

    private fun checkPermission() {
        val isAllGranted = REQUEST_PERMISSION.all { permission ->
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        }
        if (isAllGranted) {
            startCamera()
            Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show()
        } else {
            launcher.launch(REQUEST_PERMISSION)
        }
    }


    companion object {
        private val REQUEST_PERMISSION: Array<String> = buildList {
            add(Manifest.permission.CAMERA)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}
