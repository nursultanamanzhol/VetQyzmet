// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kz.cifron.vetqyzmet_doctor.R;

public final class ActivityAddAnimalsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout TopFont;

  @NonNull
  public final ConstraintLayout addAnimals;

  @NonNull
  public final ImageView arrowIcon;

  @NonNull
  public final ConstraintLayout birthDateLayout;

  @NonNull
  public final TextView birthDateText;

  @NonNull
  public final TextView birthMonth;

  @NonNull
  public final ConstraintLayout breedConst;

  @NonNull
  public final TextView breedText;

  @NonNull
  public final TextView chageText;

  @NonNull
  public final Button chooseDateButton;

  @NonNull
  public final TextInputLayout emailEt;

  @NonNull
  public final TextInputEditText emailEt1;

  @NonNull
  public final RadioButton female;

  @NonNull
  public final RadioGroup genderAnimal;

  @NonNull
  public final TextView genderText;

  @NonNull
  public final RadioButton male;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView saveBreed;

  @NonNull
  public final TextView saveType;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView typeInj;

  @NonNull
  public final ConstraintLayout typeInjConst;

  @NonNull
  public final ConstraintLayout typeconst;

  private ActivityAddAnimalsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout TopFont, @NonNull ConstraintLayout addAnimals,
      @NonNull ImageView arrowIcon, @NonNull ConstraintLayout birthDateLayout,
      @NonNull TextView birthDateText, @NonNull TextView birthMonth,
      @NonNull ConstraintLayout breedConst, @NonNull TextView breedText,
      @NonNull TextView chageText, @NonNull Button chooseDateButton,
      @NonNull TextInputLayout emailEt, @NonNull TextInputEditText emailEt1,
      @NonNull RadioButton female, @NonNull RadioGroup genderAnimal, @NonNull TextView genderText,
      @NonNull RadioButton male, @NonNull ProgressBar progressBar, @NonNull TextView saveBreed,
      @NonNull TextView saveType, @NonNull TextView textView, @NonNull TextView typeInj,
      @NonNull ConstraintLayout typeInjConst, @NonNull ConstraintLayout typeconst) {
    this.rootView = rootView;
    this.TopFont = TopFont;
    this.addAnimals = addAnimals;
    this.arrowIcon = arrowIcon;
    this.birthDateLayout = birthDateLayout;
    this.birthDateText = birthDateText;
    this.birthMonth = birthMonth;
    this.breedConst = breedConst;
    this.breedText = breedText;
    this.chageText = chageText;
    this.chooseDateButton = chooseDateButton;
    this.emailEt = emailEt;
    this.emailEt1 = emailEt1;
    this.female = female;
    this.genderAnimal = genderAnimal;
    this.genderText = genderText;
    this.male = male;
    this.progressBar = progressBar;
    this.saveBreed = saveBreed;
    this.saveType = saveType;
    this.textView = textView;
    this.typeInj = typeInj;
    this.typeInjConst = typeInjConst;
    this.typeconst = typeconst;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddAnimalsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddAnimalsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_animals, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddAnimalsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TopFont;
      ConstraintLayout TopFont = ViewBindings.findChildViewById(rootView, id);
      if (TopFont == null) {
        break missingId;
      }

      id = R.id.addAnimals;
      ConstraintLayout addAnimals = ViewBindings.findChildViewById(rootView, id);
      if (addAnimals == null) {
        break missingId;
      }

      id = R.id.arrow_icon;
      ImageView arrowIcon = ViewBindings.findChildViewById(rootView, id);
      if (arrowIcon == null) {
        break missingId;
      }

      id = R.id.birthDateLayout;
      ConstraintLayout birthDateLayout = ViewBindings.findChildViewById(rootView, id);
      if (birthDateLayout == null) {
        break missingId;
      }

      id = R.id.birthDateText;
      TextView birthDateText = ViewBindings.findChildViewById(rootView, id);
      if (birthDateText == null) {
        break missingId;
      }

      id = R.id.birthMonth;
      TextView birthMonth = ViewBindings.findChildViewById(rootView, id);
      if (birthMonth == null) {
        break missingId;
      }

      id = R.id.breedConst;
      ConstraintLayout breedConst = ViewBindings.findChildViewById(rootView, id);
      if (breedConst == null) {
        break missingId;
      }

      id = R.id.breedText;
      TextView breedText = ViewBindings.findChildViewById(rootView, id);
      if (breedText == null) {
        break missingId;
      }

      id = R.id.chageText;
      TextView chageText = ViewBindings.findChildViewById(rootView, id);
      if (chageText == null) {
        break missingId;
      }

      id = R.id.chooseDateButton;
      Button chooseDateButton = ViewBindings.findChildViewById(rootView, id);
      if (chooseDateButton == null) {
        break missingId;
      }

      id = R.id.emailEt;
      TextInputLayout emailEt = ViewBindings.findChildViewById(rootView, id);
      if (emailEt == null) {
        break missingId;
      }

      id = R.id.emailEt1;
      TextInputEditText emailEt1 = ViewBindings.findChildViewById(rootView, id);
      if (emailEt1 == null) {
        break missingId;
      }

      id = R.id.female;
      RadioButton female = ViewBindings.findChildViewById(rootView, id);
      if (female == null) {
        break missingId;
      }

      id = R.id.genderAnimal;
      RadioGroup genderAnimal = ViewBindings.findChildViewById(rootView, id);
      if (genderAnimal == null) {
        break missingId;
      }

      id = R.id.genderText;
      TextView genderText = ViewBindings.findChildViewById(rootView, id);
      if (genderText == null) {
        break missingId;
      }

      id = R.id.male;
      RadioButton male = ViewBindings.findChildViewById(rootView, id);
      if (male == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.saveBreed;
      TextView saveBreed = ViewBindings.findChildViewById(rootView, id);
      if (saveBreed == null) {
        break missingId;
      }

      id = R.id.saveType;
      TextView saveType = ViewBindings.findChildViewById(rootView, id);
      if (saveType == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.typeInj;
      TextView typeInj = ViewBindings.findChildViewById(rootView, id);
      if (typeInj == null) {
        break missingId;
      }

      id = R.id.typeInjConst;
      ConstraintLayout typeInjConst = ViewBindings.findChildViewById(rootView, id);
      if (typeInjConst == null) {
        break missingId;
      }

      id = R.id.typeconst;
      ConstraintLayout typeconst = ViewBindings.findChildViewById(rootView, id);
      if (typeconst == null) {
        break missingId;
      }

      return new ActivityAddAnimalsBinding((ConstraintLayout) rootView, TopFont, addAnimals,
          arrowIcon, birthDateLayout, birthDateText, birthMonth, breedConst, breedText, chageText,
          chooseDateButton, emailEt, emailEt1, female, genderAnimal, genderText, male, progressBar,
          saveBreed, saveType, textView, typeInj, typeInjConst, typeconst);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}