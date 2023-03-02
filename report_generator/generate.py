from docxtpl import DocxTemplate
import docx
from docxcompose.composer import Composer
from pathlib import Path
import os

ROOT_DIR = Path(__file__).parent
TEMPLATES = ROOT_DIR / 'templates'
TEMP = ROOT_DIR / 'temp'
OUT = ROOT_DIR / 'out'


def get_docstring(java_code):
    start_index = java_code.find("/**")
    end_index = java_code.find("*/", start_index)
    if start_index == -1 or end_index == -1:
        return None
    docstring = " ".join([s.strip()[1:].strip() for s in java_code[start_index:end_index+2].strip().split('\n')[2:-1]])
    return docstring

def renderdoc(to_merge, template, data):
    doc = DocxTemplate(template)
    doc.render(data)
    docname = TEMP / f"{len(to_merge)}.docx"
    to_merge.append(docname)
    doc.save(docname)

titul_data = {
    "lab_no": 0,
    "lab_name": "",
}
task_data_list = []
conclusion_data = {
    "conclusion": ""
}


titul_data["lab_name"] = input("Enter lab name: ")
LAB_PATH = Path(input("Enter lab folder path: "))
titul_data["lab_no"] = LAB_PATH.name[1:]
conclusion_data["conclusion"] += f'Я сделал лабораторную работу по Java на тему "{titul_data["lab_name"]}". В лабораторной работе я сделал следующие задания:\n'
for i, e in enumerate(LAB_PATH.glob("e*.java")):
    task_data = {
        "task_no": i+1,
        "task_text": "",
        "task_code": ""
    }
    with open(e, encoding="utf8") as f:
        task_data["task_code"] = f.read()
    task_data["task_text"] = get_docstring(task_data["task_code"])
    task_data_list.append(task_data)
    conclusion_data["conclusion"]+=f'{i+1}. {task_data["task_text"]}\n'
conclusion_data["conclusion"]+="\nНапиши небольшой вывод, который нужно написать в конце данной лабораторной работы."
print(f"\nChatGPT request:\n\n{conclusion_data['conclusion']}\n")
conclusion_data["conclusion"] = input("Enter conclusion:\n")


to_merge = []

renderdoc(to_merge, TEMPLATES / 'title.docx', titul_data)
for task_data in task_data_list:
    renderdoc(to_merge, TEMPLATES / 'task.docx', task_data)
renderdoc(to_merge, TEMPLATES / 'result.docx', conclusion_data)


master = docx.Document(to_merge[0])
composer = Composer(master)
for file_name in to_merge[1:]:
    composer.append(docx.Document(file_name))
    os.remove(file_name)
master.save(LAB_PATH / f'Панфилкин Отчет {titul_data["lab_no"]}.docx')
os.remove(to_merge[0])
