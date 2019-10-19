# -*- coding:utf-8 -*-
from bs4 import BeautifulSoup
import requests

url = "https://www.bilibili.com"
res = requests.get(url)
res.encoding = 'utf-8'
soup = BeautifulSoup(res, 'html.parser')
print(soup)
