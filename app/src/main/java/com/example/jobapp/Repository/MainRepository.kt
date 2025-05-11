package com.example.jobapp.Repository

import com.example.jobapp.Model.JobModel

class MainRepository {

    val location = listOf("Лос-Анджелес, США", "Ньюарк, США")
    val category = listOf("Все", "Бухгалтер", "Программист", "Писатель")

    val exampleText: String = "Мы ищем талантливого и мотивированного сотрудника на эту должность, чтобы присоединиться к нашей команде." +
            "В этой роли вы будете ответственны за выполнение обязанностей, связанных с этой работой."

    val items = listOf(
        JobModel(
            "UI-дизайнер",
            "ChabokSoft",
            "logo1",
            "Полная занятость",
            "Удалённо",
            "Стажировка",
            "Нью-Йорк, США",
            "\$38k - \$46k",
            "2",
            exampleText,
            exampleText
        ),
        JobModel(
            "Бухгалтер",
            "KianSoft",
            "logo2",
            "Частичная занятость",
            "Удалённо",
            "Очно",
            "Лос-Анджелес, США",
            "\$26k - \$36k",
            "1",
            exampleText,
            exampleText
        ),
        JobModel(
            "Автор новостей",
            "KomSoft",
            "logo3",
            "Частичная занятость",
            "Удалённо",
            "Старший уровень",
            "Ньюарк, США",
            "\$20k - \$23k",
            "3",
            exampleText,
            exampleText
        ),
        JobModel(
            "Программист Kotlin",
            "AndroSoft",
            "logo4",
            "Полная занятость",
            "Удалённо",
            "Стажировка",
            "Лос-Анджелес, США",
            "\$38k - \$40k",
            "2",
            exampleText,
            exampleText
        ),
    )
}
