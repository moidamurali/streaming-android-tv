/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package android.support.v17.leanback.streamingapp.old.oldcards.presenters;

import android.content.Context;
import android.support.v17.leanback.streamingapp.R;
import android.support.v17.leanback.streamingapp.old.oldmodels.OldCard;
import android.support.v17.leanback.widget.ImageCardView;
import android.view.ContextThemeWrapper;

import com.squareup.picasso.Picasso;

/**
 * A very basic {@link ImageCardView} {@link android.support.v17.leanback.widget.Presenter}.You can
 * pass a custom style for the ImageCardView in the constructor. Use the default constructor to
 * create a Presenter with a default ImageCardView style.
 */
public class OldImageCardViewPresenterOld extends OldAbstractCardPresenter<ImageCardView> {

    public OldImageCardViewPresenterOld(Context context, int cardThemeResId) {
        super(new ContextThemeWrapper(context, cardThemeResId));
    }

    public OldImageCardViewPresenterOld(Context context) {
        this(context, R.style.DefaultCardTheme);
    }

    @Override
    protected ImageCardView onCreateView() {
        ImageCardView imageCardView = new ImageCardView(getContext());
//        imageCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Clicked on ImageCardView", Toast.LENGTH_SHORT).show();
//            }
//        });
        return imageCardView;
    }

    @Override
    public void onBindViewHolder(OldCard oldCard, final ImageCardView cardView) {
        cardView.setTag(oldCard);
        cardView.setTitleText(oldCard.getTitle());
        cardView.setContentText(oldCard.getDescription());

        if (oldCard.getImage() != null) {
            Picasso.with(getContext()).load(oldCard.getImage()).into(cardView.getMainImageView());

        } else if (oldCard.getLocalImageResourceName() != null) {
            int resourceId = getContext().getResources()
                    .getIdentifier(oldCard.getLocalImageResourceName(),
                            "drawable", getContext().getPackageName());
            Picasso.with(getContext()).load(resourceId).into(cardView.getMainImageView());
        }
    }

}
