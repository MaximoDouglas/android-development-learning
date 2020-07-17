package br.com.argmax.githubconsumer.components.repositorycard.context

import android.app.Activity
import android.view.View
import br.com.argmax.githubconsumer.components.BaseComponentTest
import br.com.argmax.githubconsumer.ui.components.repositorycard.GitRepositoryCardComponent
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto
import br.com.argmax.githubconsumer.utils.compactStringWithDots
import kotlinx.android.synthetic.main.git_repository_card_component.view.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

open class RepositoryCardTest : BaseComponentTest() {

    companion object {

        private const val REPOSITORY_NAME =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

        private const val LONG_REPOSITORY_DESCRIPTION = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley"

        private const val FORKS_QUANTITY = 640.toString()

        private const val STARS_QUANTITY = 98.toString()

        private const val USER_IMAGE_URL = "https://picsum.photos/200"

        private const val USER_NAME =
            "survived not only five centuries, but also the leap into electronic"

    }

    private var mRepositoryCardComponent: GitRepositoryCardComponent? = null

    override fun setupComponent(activity: Activity) {
        mRepositoryCardComponent = GitRepositoryCardComponent(activity)
    }

    fun `when repository card has all data`() {
        val repositoryCardDto = GitRepositoryCardDto(
            gitRepositoryName = REPOSITORY_NAME,
            gitRepositoryDescription = LONG_REPOSITORY_DESCRIPTION,
            forkQuantity = FORKS_QUANTITY,
            starsQuantity = STARS_QUANTITY,
            userImageUrl = USER_IMAGE_URL,
            userName = USER_NAME
        )

        mRepositoryCardComponent?.setRepositoryCardDto(repositoryCardDto)
    }

    fun `assert that repository name is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_repository_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository name is set correctly`() {
        assertEquals(
            REPOSITORY_NAME,
            mRepositoryCardComponent?.git_repository_card_repository_name_text_view?.text.toString()
        )
    }

    fun `assert that repository description is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository description is set correctly`() {
        val maxLengthDescription = 60
        val shortString = compactStringWithDots(LONG_REPOSITORY_DESCRIPTION, maxLengthDescription)

        assertEquals(
            shortString,
            mRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.text.toString()
        )
    }

    fun `assert that repository stars quantity label is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_git_repository_stars_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository stars quantity label is set correctly`() {
        assertEquals(
            STARS_QUANTITY,
            mRepositoryCardComponent?.git_repository_card_git_repository_stars_text_view?.text.toString()
        )
    }

    fun `assert that repository forks quantity label is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_git_repository_forks_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository forks quantity label is set correctly`() {
        assertEquals(
            FORKS_QUANTITY,
            mRepositoryCardComponent?.git_repository_card_git_repository_forks_text_view?.text.toString()
        )
    }

    fun `assert that user image is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_user_image_image_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is visible`() {
        assertTrue(mRepositoryCardComponent?.git_repository_card_user_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is set correctly`() {
        assertEquals(
            USER_NAME,
            mRepositoryCardComponent?.git_repository_card_user_name_text_view?.text.toString()
        )
    }

}