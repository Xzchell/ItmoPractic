import unittest, Informatics_Lab3_Task3


class TestTask3(unittest.TestCase):

    def test_example_from_assignment(self):
        text = (
            "Футбольный клуб «Реал Мадрид» является 15-кратным обладателем главного\n"
            "футбольного европейского трофея – Лиги Чемпионов. Данный турнир организован\n"
            "Союзом европейских футбольных ассоциаций (УЕФА). Идея о континентальном\n"
            "футбольном турнире пришла к журналисту Габриэлю Ано в 1955 году."
        )

        expected = (
            "Футбольного клуб «Реал Мадрид» является 15-кратным обладателем главного\n"
            "футбольного европейского трофея – Лиги Чемпионов. Данный турнир организован\n"
            "Союзом европейских футбольного ассоциаций (УЕФА). Идея о континентальном\n"
            "футбольного турнире пришла к журналисту Габриэлю Ано в 1955 году."
        )

        self.assertEqual(
            Informatics_Lab3_Task3.replace_adjective_forms(text, 2),
            expected
        )

    def test_first_form_is_used(self):
        text = "Красивый дом. Красивого дома. Красивому дому."
        expected = "Красивый дом. Красивый дома. Красивый дому."

        self.assertEqual(
            Informatics_Lab3_Task3.replace_adjective_forms(text, 1),
            expected
        )

    def test_unrelated_words_are_preserved(self):
        text = "Футбольный матч. Футбольного клуба. Красивый дом."
        expected = "Футбольный матч. Футбольный клуба. Красивый дом."

        self.assertEqual(
            Informatics_Lab3_Task3.replace_adjective_forms(text, 1),
            expected
        )

    def test_zero_number(self):
        text = "Футбольный матч. Футбольного клуба."

        with self.assertRaises(ValueError):
            Informatics_Lab3_Task3.replace_adjective_forms(text, 0)

    def test_number_too_large(self):
        text = "Футбольный матч. Футбольного клуба."

        with self.assertRaises(ValueError):
            Informatics_Lab3_Task3.replace_adjective_forms(text, 10)


if __name__ == "__main__":
    unittest.main()