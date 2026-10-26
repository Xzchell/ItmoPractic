import Informatics_Lab3_Task1, unittest

class TestTask1(unittest.TestCase):
    def test1(self):
        data = "Кривошеее существо гуляет по парку"
        result = "гуляет"
        self.assertEqual(result, Informatics_Lab3_Task1.find_words(data))

    def test2(self):
        data = "Гигачад спокойно пьёт кофе"
        result = ""
        self.assertEqual(result, Informatics_Lab3_Task1.find_words(data))
    
    def test3(self):
        data = "Поооофиг я всё равно сдам экзамен"
        result = "Поооофиг"
        self.assertEqual(result, Informatics_Lab3_Task1.find_words(data))
    
    def test4(self):
        data = "оооо оопрпр аагр"
        result = "оопрпр"
        self.assertEqual(result, Informatics_Lab3_Task1.find_words(data))
    
    def test5(self):
        data = "ооо ааа ыыы ваа оово"
        result = "ооо ааа ыыы ваа"
        self.assertEqual(result, Informatics_Lab3_Task1.find_words(data))

if __name__ == '__main__':
    unittest.main()