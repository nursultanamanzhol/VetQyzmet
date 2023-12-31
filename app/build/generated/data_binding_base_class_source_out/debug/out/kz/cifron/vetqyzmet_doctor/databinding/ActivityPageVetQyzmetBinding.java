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
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kz.cifron.vetqyzmet_doctor.R;

public final class ActivityPageVetQyzmetBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final TextView LogoutTextView;

  @NonNull
  public final ConstraintLayout backBtnLogout;

  @NonNull
  public final ConstraintLayout bottomCustom;

  @NonNull
  public final ConstraintLayout btnFinalized;

  @NonNull
  public final ImageView btnNavView;

  @NonNull
  public final ConstraintLayout centerCustom;

  @NonNull
  public final ConstraintLayout certificates;

  @NonNull
  public final ImageView controlerId;

  @NonNull
  public final DrawerLayout drawer;

  @NonNull
  public final ImageView finalizedImg;

  @NonNull
  public final TextView finalizedText;

  @NonNull
  public final ConstraintLayout form;

  @NonNull
  public final ImageView imageView1;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final View lineOwner;

  @NonNull
  public final ConstraintLayout linear1;

  @NonNull
  public final ImageView locationIcon;

  @NonNull
  public final ImageView logOutIcon;

  @NonNull
  public final ImageView logoutBtnHeader;

  @NonNull
  public final ConstraintLayout migration;

  @NonNull
  public final ImageView navigate1;

  @NonNull
  public final ImageView profileIc;

  @NonNull
  public final TextView regAnimalPage;

  @NonNull
  public final ConstraintLayout registr;

  @NonNull
  public final ConstraintLayout topCustom;

  @NonNull
  public final ConstraintLayout topToolbarCustom;

  @NonNull
  public final TextView userCityText;

  @NonNull
  public final TextView userId;

  @NonNull
  public final TextView userNameText;

  @NonNull
  public final TextView vetQyzmetTitle;

  private ActivityPageVetQyzmetBinding(@NonNull DrawerLayout rootView,
      @NonNull TextView LogoutTextView, @NonNull ConstraintLayout backBtnLogout,
      @NonNull ConstraintLayout bottomCustom, @NonNull ConstraintLayout btnFinalized,
      @NonNull ImageView btnNavView, @NonNull ConstraintLayout centerCustom,
      @NonNull ConstraintLayout certificates, @NonNull ImageView controlerId,
      @NonNull DrawerLayout drawer, @NonNull ImageView finalizedImg,
      @NonNull TextView finalizedText, @NonNull ConstraintLayout form,
      @NonNull ImageView imageView1, @NonNull ImageView imageView2, @NonNull ImageView imageView3,
      @NonNull ImageView imageView4, @NonNull View lineOwner, @NonNull ConstraintLayout linear1,
      @NonNull ImageView locationIcon, @NonNull ImageView logOutIcon,
      @NonNull ImageView logoutBtnHeader, @NonNull ConstraintLayout migration,
      @NonNull ImageView navigate1, @NonNull ImageView profileIc, @NonNull TextView regAnimalPage,
      @NonNull ConstraintLayout registr, @NonNull ConstraintLayout topCustom,
      @NonNull ConstraintLayout topToolbarCustom, @NonNull TextView userCityText,
      @NonNull TextView userId, @NonNull TextView userNameText, @NonNull TextView vetQyzmetTitle) {
    this.rootView = rootView;
    this.LogoutTextView = LogoutTextView;
    this.backBtnLogout = backBtnLogout;
    this.bottomCustom = bottomCustom;
    this.btnFinalized = btnFinalized;
    this.btnNavView = btnNavView;
    this.centerCustom = centerCustom;
    this.certificates = certificates;
    this.controlerId = controlerId;
    this.drawer = drawer;
    this.finalizedImg = finalizedImg;
    this.finalizedText = finalizedText;
    this.form = form;
    this.imageView1 = imageView1;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.lineOwner = lineOwner;
    this.linear1 = linear1;
    this.locationIcon = locationIcon;
    this.logOutIcon = logOutIcon;
    this.logoutBtnHeader = logoutBtnHeader;
    this.migration = migration;
    this.navigate1 = navigate1;
    this.profileIc = profileIc;
    this.regAnimalPage = regAnimalPage;
    this.registr = registr;
    this.topCustom = topCustom;
    this.topToolbarCustom = topToolbarCustom;
    this.userCityText = userCityText;
    this.userId = userId;
    this.userNameText = userNameText;
    this.vetQyzmetTitle = vetQyzmetTitle;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPageVetQyzmetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPageVetQyzmetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_page_vet_qyzmet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPageVetQyzmetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LogoutTextView;
      TextView LogoutTextView = ViewBindings.findChildViewById(rootView, id);
      if (LogoutTextView == null) {
        break missingId;
      }

      id = R.id.backBtnLogout;
      ConstraintLayout backBtnLogout = ViewBindings.findChildViewById(rootView, id);
      if (backBtnLogout == null) {
        break missingId;
      }

      id = R.id.bottom_custom;
      ConstraintLayout bottomCustom = ViewBindings.findChildViewById(rootView, id);
      if (bottomCustom == null) {
        break missingId;
      }

      id = R.id.btn_finalized;
      ConstraintLayout btnFinalized = ViewBindings.findChildViewById(rootView, id);
      if (btnFinalized == null) {
        break missingId;
      }

      id = R.id.btnNavView;
      ImageView btnNavView = ViewBindings.findChildViewById(rootView, id);
      if (btnNavView == null) {
        break missingId;
      }

      id = R.id.center_custom;
      ConstraintLayout centerCustom = ViewBindings.findChildViewById(rootView, id);
      if (centerCustom == null) {
        break missingId;
      }

      id = R.id.certificates;
      ConstraintLayout certificates = ViewBindings.findChildViewById(rootView, id);
      if (certificates == null) {
        break missingId;
      }

      id = R.id.controler_id;
      ImageView controlerId = ViewBindings.findChildViewById(rootView, id);
      if (controlerId == null) {
        break missingId;
      }

      DrawerLayout drawer = (DrawerLayout) rootView;

      id = R.id.finalizedImg;
      ImageView finalizedImg = ViewBindings.findChildViewById(rootView, id);
      if (finalizedImg == null) {
        break missingId;
      }

      id = R.id.finalizedText;
      TextView finalizedText = ViewBindings.findChildViewById(rootView, id);
      if (finalizedText == null) {
        break missingId;
      }

      id = R.id.form;
      ConstraintLayout form = ViewBindings.findChildViewById(rootView, id);
      if (form == null) {
        break missingId;
      }

      id = R.id.imageView1;
      ImageView imageView1 = ViewBindings.findChildViewById(rootView, id);
      if (imageView1 == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.lineOwner;
      View lineOwner = ViewBindings.findChildViewById(rootView, id);
      if (lineOwner == null) {
        break missingId;
      }

      id = R.id.linear1;
      ConstraintLayout linear1 = ViewBindings.findChildViewById(rootView, id);
      if (linear1 == null) {
        break missingId;
      }

      id = R.id.locationIcon;
      ImageView locationIcon = ViewBindings.findChildViewById(rootView, id);
      if (locationIcon == null) {
        break missingId;
      }

      id = R.id.logOutIcon;
      ImageView logOutIcon = ViewBindings.findChildViewById(rootView, id);
      if (logOutIcon == null) {
        break missingId;
      }

      id = R.id.logoutBtnHeader;
      ImageView logoutBtnHeader = ViewBindings.findChildViewById(rootView, id);
      if (logoutBtnHeader == null) {
        break missingId;
      }

      id = R.id.migration;
      ConstraintLayout migration = ViewBindings.findChildViewById(rootView, id);
      if (migration == null) {
        break missingId;
      }

      id = R.id.navigate1;
      ImageView navigate1 = ViewBindings.findChildViewById(rootView, id);
      if (navigate1 == null) {
        break missingId;
      }

      id = R.id.profile_ic;
      ImageView profileIc = ViewBindings.findChildViewById(rootView, id);
      if (profileIc == null) {
        break missingId;
      }

      id = R.id.regAnimalPage;
      TextView regAnimalPage = ViewBindings.findChildViewById(rootView, id);
      if (regAnimalPage == null) {
        break missingId;
      }

      id = R.id.registr;
      ConstraintLayout registr = ViewBindings.findChildViewById(rootView, id);
      if (registr == null) {
        break missingId;
      }

      id = R.id.top_custom;
      ConstraintLayout topCustom = ViewBindings.findChildViewById(rootView, id);
      if (topCustom == null) {
        break missingId;
      }

      id = R.id.topToolbarCustom;
      ConstraintLayout topToolbarCustom = ViewBindings.findChildViewById(rootView, id);
      if (topToolbarCustom == null) {
        break missingId;
      }

      id = R.id.user_city_text;
      TextView userCityText = ViewBindings.findChildViewById(rootView, id);
      if (userCityText == null) {
        break missingId;
      }

      id = R.id.userId;
      TextView userId = ViewBindings.findChildViewById(rootView, id);
      if (userId == null) {
        break missingId;
      }

      id = R.id.user_name_text;
      TextView userNameText = ViewBindings.findChildViewById(rootView, id);
      if (userNameText == null) {
        break missingId;
      }

      id = R.id.vetQyzmetTitle;
      TextView vetQyzmetTitle = ViewBindings.findChildViewById(rootView, id);
      if (vetQyzmetTitle == null) {
        break missingId;
      }

      return new ActivityPageVetQyzmetBinding((DrawerLayout) rootView, LogoutTextView,
          backBtnLogout, bottomCustom, btnFinalized, btnNavView, centerCustom, certificates,
          controlerId, drawer, finalizedImg, finalizedText, form, imageView1, imageView2,
          imageView3, imageView4, lineOwner, linear1, locationIcon, logOutIcon, logoutBtnHeader,
          migration, navigate1, profileIc, regAnimalPage, registr, topCustom, topToolbarCustom,
          userCityText, userId, userNameText, vetQyzmetTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
