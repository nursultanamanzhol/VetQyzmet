// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kz.cifron.vetqyzmet_doctor.R;

public final class CustomRadioButtonBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView customRadioButtonIcon;

  @NonNull
  public final TextView customRadioButtonText;

  private CustomRadioButtonBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView customRadioButtonIcon, @NonNull TextView customRadioButtonText) {
    this.rootView = rootView;
    this.customRadioButtonIcon = customRadioButtonIcon;
    this.customRadioButtonText = customRadioButtonText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomRadioButtonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomRadioButtonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_radio_button, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomRadioButtonBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.customRadioButtonIcon;
      ImageView customRadioButtonIcon = ViewBindings.findChildViewById(rootView, id);
      if (customRadioButtonIcon == null) {
        break missingId;
      }

      id = R.id.customRadioButtonText;
      TextView customRadioButtonText = ViewBindings.findChildViewById(rootView, id);
      if (customRadioButtonText == null) {
        break missingId;
      }

      return new CustomRadioButtonBinding((ConstraintLayout) rootView, customRadioButtonIcon,
          customRadioButtonText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}