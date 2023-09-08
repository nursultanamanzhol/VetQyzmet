// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class OwneritemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView nameAnimal;

  @NonNull
  public final TextView numAnimal;

  @NonNull
  public final TextView numsAnimal;

  @NonNull
  public final TextView todayNum;

  @NonNull
  public final TextView todayNums;

  private OwneritemBinding(@NonNull ConstraintLayout rootView, @NonNull TextView nameAnimal,
      @NonNull TextView numAnimal, @NonNull TextView numsAnimal, @NonNull TextView todayNum,
      @NonNull TextView todayNums) {
    this.rootView = rootView;
    this.nameAnimal = nameAnimal;
    this.numAnimal = numAnimal;
    this.numsAnimal = numsAnimal;
    this.todayNum = todayNum;
    this.todayNums = todayNums;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OwneritemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OwneritemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.owneritem, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OwneritemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.name_animal;
      TextView nameAnimal = ViewBindings.findChildViewById(rootView, id);
      if (nameAnimal == null) {
        break missingId;
      }

      id = R.id.num_animal;
      TextView numAnimal = ViewBindings.findChildViewById(rootView, id);
      if (numAnimal == null) {
        break missingId;
      }

      id = R.id.nums_animal;
      TextView numsAnimal = ViewBindings.findChildViewById(rootView, id);
      if (numsAnimal == null) {
        break missingId;
      }

      id = R.id.today_num;
      TextView todayNum = ViewBindings.findChildViewById(rootView, id);
      if (todayNum == null) {
        break missingId;
      }

      id = R.id.today_nums;
      TextView todayNums = ViewBindings.findChildViewById(rootView, id);
      if (todayNums == null) {
        break missingId;
      }

      return new OwneritemBinding((ConstraintLayout) rootView, nameAnimal, numAnimal, numsAnimal,
          todayNum, todayNums);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
