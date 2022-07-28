# ocr-tesseract-demo


MACOS 환경 기준. ( 모든 버전 JAVA는  /Library/Java/JavaVirtualMachines/ 에 설치 되어 있음)

```bash
brew install tesseract
```

```bash
tesseract --version
```

cp -r /opt/homebrew/Cellar/tesseract/5.2.0/lib 파일을 /usr/lib 에 복사하려고 했지만 
permission 발

```bash

cp: /usr/lib/lib: Operation not permitted
cp: /opt/homebrew/Cellar/tesseract/5.2.0/lib: unable to copy extended attributes to /usr/lib/lib: Operation not permitted
cp: /usr/lib/lib/pkgconfig: No such file or directory
cp: /opt/homebrew/Cellar/tesseract/5.2.0/lib/pkgconfig: unable to copy extended attributes to /usr/lib/lib/pkgconfig: No such file or directory
cp: /usr/lib/lib/pkgconfig/tesseract.pc: No such file or directory
cp: /usr/lib/lib/.DS_Store: No such file or directory
cp: /usr/lib/lib/libtesseract.dylib: No such file or directory
cp: /usr/lib/lib/libtesseract.a: No such file or directory
cp: /usr/lib/lib/libtesseract.5.dylib: No such file or directory
```

결국 jdk bin/lib 폴더에 복사해넣는걸로 해결.

자신의 JDK 사용하고 있는 버전의 폴더로 이동(현 java 11 기존으로 ..) 

최종 복사 명령어 혹은 lib 폴더를 전체 복사하여 /Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home/lib로 복붙해도 된다.

```bash
cp -r /opt/homebrew/Cellar/tesseract/5.2.0/lib /Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home/lib
```

언어팩 다운로드 주소:

[https://github.com/tesseract-ocr/tessdata](https://github.com/tesseract-ocr/tessdata)

아래경로에 폴더를 생성하고 복붙한다.

```bash
# 학습언어 팩 전용 폴더 하나 만든다. 경로는 이미로 share 폴더를 택했다 ^^ 
mkdir /usr/local/share/tessdata

#참고 chi_sim :중국어 , kor:한국어 , eng:영어
```

![스크린샷 2022-07-28 오후 3.19.44.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6ad69216-face-4e2d-81e1-d7dd47592fea/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-07-28_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_3.19.44.png)
