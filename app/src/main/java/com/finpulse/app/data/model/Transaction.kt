package com.finpulse.app.data.model

import java.time.Instant

enum class TransactionType { INCOME, EXPENSE, TRANSFER, LOAN }

data class Transaction(
	val id: String = "",
	val timestamp: Long = Instant.now().toEpochMilli(),
	val amountMinor: Long = 0L,
	val currency: String = "USD",
	val merchant: String? = null,
	val description: String? = null,
	val categoryId: String? = null,
	val type: TransactionType = TransactionType.EXPENSE,
	val source: String = "manual" // sms | notification | ocr | manual
)

data class Category(
	val id: String = "",
	val name: String = "",
	val color: Long = 0xFF607D8BL
)