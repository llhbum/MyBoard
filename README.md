# 진행상황
1. 게시판CRUD 
2. 게시글 댓글
3. 파일 업로드

<h3 align="center"><strong>목차</strong></h3>

> 1. 게시판CRUD 
  > 1. List
  > 2. Create
  > 3. Read
  > 4. Update / Delete
  > 5. Pagination
  > 6. 검색
  > 7. 조회수
>
> 2. 게시글 댓글
>    > 1. 
>    > 2. 
>
> 3. 파일 업로드
>    > 1. 
>    > 2. 
>



<h3 align="center"><strong>개발목적</strong></h3>
>


<h3 align="center"><strong>기술 및 Version</strong></h3>
>

<h3 align="center"><strong>ERD</strong></h3>
<img width="602" alt="erm캡쳐" src="https://user-images.githubusercontent.com/47100164/105502613-f49d4080-5d08-11eb-8177-581195109361.PNG">

***

# How To Use

<h3 align="center"><strong> 게시판CRUD </strong></h3>

### 1. List
<img width="899" alt="list" src="https://user-images.githubusercontent.com/47100164/105016772-63b73280-5a86-11eb-8e1f-ff74cf081826.PNG">

> 1. 번호, 제목, 작성자, 등록일, 수정일, 조회수를 보여줌 / 제목 클릭시 board/get?bno='value'로 이동
> 2. board/register -> 게시물 작성으로 이동
> 3. pagination으로 페이징 처리
> 4. Title, content, writer을 이용해서 게시물 검색

### 2. Create
<img width="899" alt="register" src="https://user-images.githubusercontent.com/47100164/105017655-60707680-5a87-11eb-94a8-50d6651e6c42.PNG">

> 1. 제목/내용/작성자를 입력하면 게시글 작성
> 2. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 3. 게시글 작성중 초기화 버튼으로 초기화

### 3. Read
<img width="899" alt="get" src="https://user-images.githubusercontent.com/47100164/105018143-f5736f80-5a87-11eb-9875-877044266eb5.PNG">

> 1. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 2. /board/modify && delete ? bno = 'value'로 이동

### 4. Update / Delete
<img width="898" alt="modify_delete" src="https://user-images.githubusercontent.com/47100164/105018612-8d715900-5a88-11eb-895a-0293b5d03d14.PNG">

> 1. 수정버튼 클릭시 post방식으로 제목과 내용 전달되어 수정됨
> 2. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 3. 삭제버튼 클릭시 get방식으로 delete로 전달되어 게시물 삭제

### 5. Pagination
<img width="502" alt="페이지네이션" src="https://user-images.githubusercontent.com/47100164/105019274-420b7a80-5a89-11eb-971c-aefcd26132ec.PNG">

> 1. << 버튼 클릭 시 /board/list로 이동(첫페이지)
> 2. Previous는 이전으로 돌아곳이 없으면 없어지고 있으면 보여지게된다.
> 3. Next는 다음으로 넘어갈 곳이 있으면 생기고 없으면 없어진다.

### 6. 검색
<img width="877" alt="검색" src="https://user-images.githubusercontent.com/47100164/105019848-eab9da00-5a89-11eb-9b0d-c055384b836a.png">

> 1. 검색 조건을 줄 수 있다.
> 2. 검색 키워드를 입력 후 검색하면 조건과 조합되어 검색된다.

### 7. 조회수
<img width="72" alt="조회수" src="https://user-images.githubusercontent.com/47100164/105019307-4c2d7900-5a89-11eb-9c17-9f374c6753a6.PNG">

> 게시글의 Title 클릭시 조회수 + 1 

<h3 align="center"><strong> 게시글 댓글 </strong></h3>
>

<h3 align="center"><strong> 파일 업로드 </strong></h3>
>

<h3 align="center"><strong> 로그인/security </strong></h3>
>


