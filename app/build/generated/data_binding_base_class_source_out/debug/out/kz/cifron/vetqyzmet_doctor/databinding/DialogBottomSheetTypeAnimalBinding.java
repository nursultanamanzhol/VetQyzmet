// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public final class DialogBottomSheetTypeAnimalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout buttomClose;

  @NonNull
  public final TextView confirmButton;

  @NonNull
  public final RadioButton option1;

  @NonNull
  public final RadioButton option2;

  @NonNull
  public final RadioButton option3;

  @NonNull
  public final RadioButton option4;

  @NonNull
  public final RadioButton option5;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final View separator1;

  @NonNull
  public final View separator2;

  @NonNull
  public final View separator3;

  @NonNull
  public final View separator4;

  @NonNull
  public final View separator5;

  @NonNull
  public final TextView textTop;

  private DialogBottomSheetTypeAnimalBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout buttomClose, @NonNull TextView confirmButton,
      @NonNull RadioButton option1, @NonNull RadioButton option2, @NonNull RadioButton option3,
      @NonNull RadioButton option4, @NonNull RadioButton option5, @NonNull RadioGroup radioGroup,
      @NonNull View separator1, @NonNull View separator2, @NonNull View separator3,
      @NonNull View separator4, @NonNull View separator5, @NonNull TextView textTop) {
    this.rootView = rootView;
    this.buttomClose = buttomClose;
    this.confirmButton = confirmButton;
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.radioGroup = radioGroup;
    this.separator1 = separator1;
    this.separator2 = separator2;
    this.separator3 = separator3;
    this.separator4 = separator4;
    this.separator5 = separator5;
    this.textTop = textTop;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogBottomSheetTypeAnimalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogBottomSheetTypeAnimalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_bottom_sheet_type_animal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogBottomSheetTypeAnimalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttomClose;
      ConstraintLayout buttomClose = ViewBindings.findChildViewById(rootView, id);
      if (buttomClose == null) {
        break missingId;
      }

      id = R.id.confirmButton;
      TextView confirmButton = ViewBindings.findChildViewById(rootView, id);
      if (confirmButton == null) {
        break missingId;
      }

      id = R.id.option1;
      RadioButton option1 = ViewBindings.findChildViewById(rootView, id);
      if (option1 == null) {
        break missingId;
      }

      id = R.id.option2;
      RadioButton option2 = ViewBindings.findChildViewById(rootView, id);
      if (option2 == null) {
        break missingId;
      }

      id = R.id.option3;
      RadioButton option3 = ViewBindings.findChildViewById(rootView, id);
      if (option3 == null) {
        break missingId;
      }

      id = R.id.option4;
      RadioButton option4 = ViewBindings.findChildViewById(rootView, id);
      if (option4 == null) {
        break missingId;
      }

      id = R.id.option5;
      RadioButton option5 = ViewBindings.findChildViewById(rootView, id);
      if (option5 == null) {
        break missingId;
      }

      id = R.id.radioGroup;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.separator_1;
      View separator1 = ViewBindings.findChildViewById(rootView, id);
      if (separator1 == null) {
        break missingId;
      }

      id = R.id.separator_2;
      View separator2 = ViewBindings.findChildViewById(rootView, id);
      if (separator2 == null) {
        break missingId;
      }

      id = R.id.separator_3;
      View separator3 = ViewBindings.findChildViewById(rootView, id);
      if (separator3 == null) {
        break missingId;
      }

      id = R.id.separator_4;
      View separator4 = ViewBindings.findChildViewById(rootView, id);
      if (separator4 == null) {
        break missingId;
      }

      id = R.id.separator_5;
      View separator5 = ViewBindings.findChildViewById(rootView, id);
      if (separator5 == null) {
        break missingId;
      }

      id = R.id.textTop;
      TextView textTop = ViewBindings.findChildViewById(rootView, id);
      if (textTop == null) {
        break missingId;
      }

      return new DialogBottomSheetTypeAnimalBinding((ConstraintLayout) rootView, buttomClose,
          confirmButton, option1, option2, option3, option4, option5, radioGroup, separator1,
          separator2, separator3, separator4, separator5, textTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}