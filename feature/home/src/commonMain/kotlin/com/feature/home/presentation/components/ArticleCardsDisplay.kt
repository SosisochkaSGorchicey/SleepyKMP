package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorDisplay
import com.core.ui.uiElements.ShimmerDisplay
import com.feature.home.model.ArticleUIModel
import com.feature.home.presentation.screenmodel.HomeState

fun LazyGridScope.articleCardsDisplay(
    state: HomeState,
    modifier: Modifier
) {
    items(
        items = state.articles,
        span = {
            GridItemSpan(if (it.isFullSize) maxLineSpan else 1)
        }
    ) { articleUIItem ->
        ArticleCard(
            articleUIItem = articleUIItem,
            modifier = if (articleUIItem == state.articles.last()) modifier.padding(bottom = 16.dp)
            else Modifier
        )
    }
}

@Composable
private fun ArticleCard(
    articleUIItem: ArticleUIModel,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .aspectRatio(if (articleUIItem.isFullSize) 2.5f else 1.5f)
            .clip(AppTheme.shapes.smallCornersDp)
            .background(AppTheme.colors.milkyWhite)
            .border(
                width = 2.dp,
                shape = AppTheme.shapes.smallCornersDp,
                color = AppTheme.colors.baseGray
            )
    ) {
        ArticleCardImage(articleUIItem = articleUIItem)

        ArticleCardTextDisplay(articleUIItem = articleUIItem)
    }
}

@Composable
private fun ArticleCardImage(
    articleUIItem: ArticleUIModel
) {
    articleUIItem.backgroundImageUrl?.let { image ->
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerDisplay(background = AppTheme.colors.baseGray)
            },
            error = {
                ErrorDisplay(tintColor = AppTheme.colors.basePeachy)
            }
        )
    } ?: Box(
        modifier = Modifier
            .fillMaxSize()
            .background(articleUIItem.backgroundBrush)
    )
}

@Composable
private fun ArticleCardTextDisplay(articleUIItem: ArticleUIModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = articleUIItem.title,
            style = AppTheme.typography.bodyMediumMedium.copy(fontWeight = FontWeight.SemiBold),
            color = articleUIItem.titleColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )

        articleUIItem.description?.let {
            Text(
                text = it,
                overflow = TextOverflow.Ellipsis,
                style = AppTheme.typography.bodySmall,
                color = articleUIItem.descriptionColor,
                maxLines = if (articleUIItem.isFullSize) 4 else 2
            )
        }
    }
}
