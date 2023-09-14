// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kz.cifron.vetqyzmet_doctor.R;

public final class ActivityCameraBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView arrowBackBtn;

  @NonNull
  public final ImageButton btnGallery;

  @NonNull
  public final ImageView imageCaptureButton;

  @NonNull
  public final ImageView imgGallery;

  @NonNull
  public final PreviewView viewFinder;

  private ActivityCameraBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView arrowBackBtn,
      @NonNull ImageButton btnGallery, @NonNull ImageView imageCaptureButton,
      @NonNull ImageView imgGallery, @NonNull PreviewView viewFinder) {
    this.rootView = rootView;
    this.arrowBackBtn = arrowBackBtn;
    this.btnGallery = btnGallery;
    this.imageCaptureButton = imageCaptureButton;
    this.imgGallery = imgGallery;
    this.viewFinder = viewFinder;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_camera, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCameraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.arrow_back_btn;
      ImageView arrowBackBtn = ViewBindings.findChildViewById(rootView, id);
      if (arrowBackBtn == null) {
        break missingId;
      }

      id = R.id.btn_gallery;
      ImageButton btnGallery = ViewBindings.findChildViewById(rootView, id);
      if (btnGallery == null) {
        break missingId;
      }

      id = R.id.image_capture_button;
      ImageView imageCaptureButton = ViewBindings.findChildViewById(rootView, id);
      if (imageCaptureButton == null) {
        break missingId;
      }

      id = R.id.img_gallery;
      ImageView imgGallery = ViewBindings.findChildViewById(rootView, id);
      if (imgGallery == null) {
        break missingId;
      }

      id = R.id.viewFinder;
      PreviewView viewFinder = ViewBindings.findChildViewById(rootView, id);
      if (viewFinder == null) {
        break missingId;
      }

      return new ActivityCameraBinding((ConstraintLayout) rootView, arrowBackBtn, btnGallery,
          imageCaptureButton, imgGallery, viewFinder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
