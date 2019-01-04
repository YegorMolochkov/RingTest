package com.example.gosha.ringTest.domain.base

import io.reactivex.Scheduler

data class Workers(val subscribe: Scheduler, val observe: Scheduler)