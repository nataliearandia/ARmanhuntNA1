package com.example.gwclt24.armanhuntna1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LISUActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisu);
    }
        public void createSignInIntent ()
        {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build(),
                    new AuthUI.IdpConfig.FacebookBuilder().build());

            // Create and launch sign-in intent
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


    public void signOut () {
            // [START auth_fui_signout]
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // ...
                        }
                    });
            // [END auth_fui_signout]
        }

        //public void themeAndLogo() {
        //  List<AuthUI.IdpConfig> providers = Collections.emptyList();

        // [START auth_fui_theme_logo for CUSTOMIZABLE theme/design]
        ////startActivityForResult(
        // AuthUI.getInstance()
        //   .createSignInIntentBuilder()
        //    .setAvailableProviders(providers)
        //   .setLogo(R.drawable.com_facebook_button_icon)      // Set logo drawable
        //    .setTheme(R.style.Theme_AppCompat)      // Set theme
        //  .build(),
        //       RC_SIGN_IN);
        // [END auth_fui_theme_logo]

        // [END auth_fui_result]

        public void privacyAndTerms () {
            List<AuthUI.IdpConfig> providers = Collections.emptyList();
            // [START auth_fui_pp_tos]
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .setTosAndPrivacyPolicyUrls(
                                    "https://example.com/terms.html",
                                    "https://example.com/privacy.html")
                            .build(),
                    RC_SIGN_IN);
            // [END auth_fui_pp_tos]
        }
    }
}