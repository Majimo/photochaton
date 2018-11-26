package dev.majimo.photochaton.model

import android.arch.persistence.room.Entity
import java.util.*

@Entity
class Picture (val id: Int, val url: String, val name: String, val createdAt: Date)