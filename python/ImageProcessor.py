import typer
from PIL import Image

obj = typer.Typer()

@obj.command()
def finder():
    print("Enter the command below to convert image format")
    print("python3 imgProcessor.py imgformat")
    print("Ener the command below to resize the image")
    print("python3 imgProcessor.py imgsizing")
    
@obj.command()
def imgformat():

    print("Conertions on jpg,jpeg,png files only")
    imgname = str(input("Enter imagename with extention\n"))
    imgformat = str(input("Enter image format\n")) 
    
    if imgformat == 'png':
        image01 = Image.open(f'{imgname}')
        image01.save('img001.jpg')
        image01.save('img0012.jpeg')
        print("png image converted into jpeg ang jpg")
    elif imgformat == 'jpg':
        image01 = Image.open(f'{imgname}')
        image01.save('img001.png')
        image01.save('img0012.jpeg')
        print("jpg image converted into png ang jpeg")
    elif imgformat == 'jpeg':
        image01 = Image.open(f'{imgname}')
        image01.save('img001.jpg')
        image01.save('img0012.png')
        print("jpeg image converted into png ang jpg")

@obj.command()
def imgsizing():
    imgname = str(input("Enter imagename with extention\n"))
    width = int(input("Enter new image width\n"))
    height = int(input("Enter new image height\n"))
    size = width,height
    
    image2 = Image.open(f'{imgname}') # Here used f string
    image2.thumbnail(size)
    image2.save(f'11{imgname}')
    print("Image resizing is completed")
    

if __name__ == "__main__":
    obj()