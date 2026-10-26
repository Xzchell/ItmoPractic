import unittest, Informatics_Lab3_Task2

class TestTask2(unittest.TestCase):

    def test1_valid_email(self):
        data = "students@spam@yandex.ru"
        result = "yandex.ru"
        print("data = " + data, "res = " + result)
        self.assertEqual(Informatics_Lab3_Task2.check_email(data), result)

    def test2_valid_email_with_subdomain(self):
        data = "user_123@mail.example.com"
        result = "mail.example.com"
        print(data, result)
        self.assertEqual(Informatics_Lab3_Task2.check_email(data),result)

    def test3_missing_at(self):
        data = "example.com"
        result = "Fail!"
        print(data, result)
        self.assertEqual(Informatics_Lab3_Task2.check_email(data), result)

    def test4_missing_top_level_domain(self):
        data = "example.com"
        result = "Fail!"
        print(data, result)
        self.assertEqual(Informatics_Lab3_Task2.check_email(data), result)

    def test5_digits_in_server(self):
        data = "example@ya123ndex.ru"
        result = "Fail!"
        print(data, result)
        self.assertEqual(Informatics_Lab3_Task2.check_email(data), result)


if __name__ == "__main__":
    unittest.main()
