package dev.majimo.photochaton.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.sql.Timestamp
import java.util.*

@Entity
class Picture (@PrimaryKey(autoGenerate = true)val id: Int, val url: String, val name: String, val createdAt: Timestamp)