package com.finpulse.app.data

import com.finpulse.app.data.model.Transaction
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class TransactionsRepository(
	private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
	suspend fun addTransaction(transaction: Transaction) {
		val id = if (transaction.id.isNotEmpty()) transaction.id else firestore.collection("transactions").document().id
		firestore.collection("transactions").document(id).set(transaction.copy(id = id)).await()
	}

	suspend fun listTransactions(limit: Long = 100): List<Transaction> {
		return firestore.collection("transactions")
			.orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
			.limit(limit)
			.get().await()
			.toObjects(Transaction::class.java)
	}
}