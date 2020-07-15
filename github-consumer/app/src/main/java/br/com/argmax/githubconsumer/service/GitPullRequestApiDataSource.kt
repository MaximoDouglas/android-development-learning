package br.com.argmax.githubconsumer.service

import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitPullRequestApiDataSource {

    @GET("repos/{owner}/{repository}/pulls")
    fun getGitPullRequests(
        @Path("owner") owner: String,
        @Path("repository") repository: String,
        @Query("page") page: Int? = 1,
        @Query("state") state: String? = "all"
    ): Observable<List<GitPullRequestDto>>

}