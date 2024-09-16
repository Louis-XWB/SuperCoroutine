package com.novar.supercorouutine._1_basics

import com.novar.supercorouutine.common.Contributor
import com.novar.supercorouutine.common.gitHub

suspend fun getRetrofitContributors(): List<Contributor> {
    return gitHub.contributors("square", "retrofit")
}