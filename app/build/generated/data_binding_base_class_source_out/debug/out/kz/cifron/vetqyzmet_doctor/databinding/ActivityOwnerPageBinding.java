// Generated by view binder compiler. Do not edit!
package kz.cifron.vetqyzmet_doctor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kz.cifron.vetqyzmet_doctor.R;

public final class ActivityOwnerPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout TopFont;

  @NonNull
  public final Button addAnimals;

  @NonNull
  public final View animalsView;

  @NonNull
  public final ImageView arrowIcon;

  @NonNull
  public final TextView dataProverka;

  @NonNull
  public final View lineOwner;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView textClient;

  @NonNull
  public final TextView textCvNumber;

  @NonNull
  public final TextView textDetail;

  @NonNull
  public final TextView textLocation;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textWrite;

  private ActivityOwnerPageBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout TopFont, @NonNull Button addAnimals, @NonNull View animalsView,
      @NonNull ImageView arrowIcon, @NonNull TextView dataProverka, @NonNull View lineOwner,
      @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView,
      @NonNull TextView textClient, @NonNull TextView textCvNumber, @NonNull TextView textDetail,
      @NonNull TextView textLocation, @NonNull TextView textView, @NonNull TextView textWrite) {
    this.rootView = rootView;
    this.TopFont = TopFont;
    this.addAnimals = addAnimals;
    this.animalsView = animalsView;
    this.arrowIcon = arrowIcon;
    this.dataProverka = dataProverka;
    this.lineOwner = lineOwner;
    this.progressBar = progressBar;
    this.recyclerView = recyclerView;
    this.textClient = textClient;
    this.textCvNumber = textCvNumber;
    this.textDetail = textDetail;
    this.textLocation = textLocation;
    this.textView = textView;
    this.textWrite = textWrite;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOwnerPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOwnerPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_owner_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOwnerPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TopFont;
      ConstraintLayout TopFont = ViewBindings.findChildViewById(rootView, id);
      if (TopFont == null) {
        break missingId;
      }

      id = R.id.add_animals;
      Button addAnimals = ViewBindings.findChildViewById(rootView, id);
      if (addAnimals == null) {
        break missingId;
      }

      id = R.id.animals_view;
      View animalsView = ViewBindings.findChildViewById(rootView, id);
      if (animalsView == null) {
        break missingId;
      }

      id = R.id.arrow_icon;
      ImageView arrowIcon = ViewBindings.findChildViewById(rootView, id);
      if (arrowIcon == null) {
        break missingId;
      }

      id = R.id.dataProverka;
      TextView dataProverka = ViewBindings.findChildViewById(rootView, id);
      if (dataProverka == null) {
        break missingId;
      }

      id = R.id.lineOwner;
      View lineOwner = ViewBindings.findChildViewById(rootView, id);
      if (lineOwner == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.recycler_view;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.text_client;
      TextView textClient = ViewBindings.findChildViewById(rootView, id);
      if (textClient == null) {
        break missingId;
      }

      id = R.id.text_cv_number;
      TextView textCvNumber = ViewBindings.findChildViewById(rootView, id);
      if (textCvNumber == null) {
        break missingId;
      }

      id = R.id.text_detail;
      TextView textDetail = ViewBindings.findChildViewById(rootView, id);
      if (textDetail == null) {
        break missingId;
      }

      id = R.id.textLocation;
      TextView textLocation = ViewBindings.findChildViewById(rootView, id);
      if (textLocation == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.text_write;
      TextView textWrite = ViewBindings.findChildViewById(rootView, id);
      if (textWrite == null) {
        break missingId;
      }

      return new ActivityOwnerPageBinding((ConstraintLayout) rootView, TopFont, addAnimals,
          animalsView, arrowIcon, dataProverka, lineOwner, progressBar, recyclerView, textClient,
          textCvNumber, textDetail, textLocation, textView, textWrite);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
