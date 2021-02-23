# 진행상황
1. 게시판CRUD 
2. 게시글 댓글
3. 파일 업로드

<h3 align="center"><strong>목차</strong></h3>

> 1. 게시판CRUD 
>       1. List
>       2. Create
>       3. Read
>       4. Update / Delete
>       5. Pagination
>       6. 검색
>       7. 조회수
>
> 2. 게시글 댓글
>       1. 댓글등록
>       2. 댓글삭제
>
> 3. 파일 업로드
>       1. 파일,사진 등록
>       2. 파일,사진 삭제
>       3. 사진 확대



<h3 align="center"><strong>개발목적</strong></h3>
> Spring의 기본을 닦기위해서 1.게시판CRUD 2.댓글 3.파일 업로드에 관한 웹서비스를 만들었다. 


<h3 align="center"><strong>기술 및 Version</strong></h3>
> 

<h3 align="center"><strong>ERD</strong></h3>
<img width="877" alt="erm캡쳐" src="https://user-images.githubusercontent.com/47100164/108849873-020a5b00-7626-11eb-8b6d-35b87912802d.PNG">

***

# How To Use

<h3 align="center"><strong> 게시판CRUD </strong></h3>
<br/>
1. List
<img width="877" alt="list" src="https://user-images.githubusercontent.com/47100164/105016772-63b73280-5a86-11eb-8e1f-ff74cf081826.PNG">

> 1. 번호, 제목, 작성자, 등록일, 수정일, 조회수를 보여줌 / 제목 클릭시 board/get?bno='value'로 이동
> 2. board/register -> 게시물 작성으로 이동
> 3. pagination으로 페이징 처리
> 4. Title, content, writer을 이용해서 게시물 검색
<br/>
2. Create
<img width="877" alt="register" src="https://user-images.githubusercontent.com/47100164/105017655-60707680-5a87-11eb-94a8-50d6651e6c42.PNG">

> 1. 제목/내용/작성자를 입력하면 게시글 작성
> 2. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 3. 게시글 작성중 초기화 버튼으로 초기화
<br/>
3. Read
<img width="877" alt="get" src="https://user-images.githubusercontent.com/47100164/105018143-f5736f80-5a87-11eb-9875-877044266eb5.PNG">

> 1. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 2. /board/modify && delete ? bno = 'value'로 이동
<br/>
4. Update / Delete
<img width="877" alt="modify_delete" src="https://user-images.githubusercontent.com/47100164/105018612-8d715900-5a88-11eb-895a-0293b5d03d14.PNG">

> 1. 수정버튼 클릭시 post방식으로 제목과 내용 전달되어 수정됨
> 2. 목록으로 이동시 pageNum과 amount값을 get으로 이동 -> 전에 보던 페이지 그대로 이동
> 3. 삭제버튼 클릭시 get방식으로 delete로 전달되어 게시물 삭제
<br/>
5. Pagination
<img width="502" alt="페이지네이션" src="https://user-images.githubusercontent.com/47100164/105019274-420b7a80-5a89-11eb-971c-aefcd26132ec.PNG">

> 1. << 버튼 클릭 시 /board/list로 이동(첫페이지)
> 2. Previous는 이전으로 돌아곳이 없으면 없어지고 있으면 보여지게된다.
> 3. Next는 다음으로 넘어갈 곳이 있으면 생기고 없으면 없어진다.
<br/>
6. 검색
<img width="877" alt="검색" src="https://user-images.githubusercontent.com/47100164/105019848-eab9da00-5a89-11eb-9b0d-c055384b836a.png">

> 1. 검색 조건을 줄 수 있다.
> 2. 검색 키워드를 입력 후 검색하면 조건과 조합되어 검색된다.

<br/>

7. 조회수
<img width="72" alt="조회수" src="https://user-images.githubusercontent.com/47100164/105019307-4c2d7900-5a89-11eb-9c17-9f374c6753a6.PNG">

> 게시글의 Title 클릭시 조회수 + 1 


<br/>
<br/>
<br/>
<br/>


<h3 align="center"><strong> 게시글 댓글 </strong></h3>
<br/>
<br/>
1-1. 댓글등록1
<img width="877" alt="댓글등록1" src="https://user-images.githubusercontent.com/47100164/108851559-e902a980-7627-11eb-8af2-7b9995876d9f.PNG">
<br/>
1-2. 댓글등록2
<img width="877" alt="댓글등록2" src="https://user-images.githubusercontent.com/47100164/108851754-1f402900-7628-11eb-95f3-a44aaa2c2d64.PNG">
<br/>
1-3. 댓글등록3  
<img width="877" alt="댓글등록3" src="https://user-images.githubusercontent.com/47100164/108851830-354de980-7628-11eb-9195-04ac2eec5fb5.PNG">
<br/>
1-4. 댓글등록4  
<img width="877" alt="댓글등록4" src="https://user-images.githubusercontent.com/47100164/108851856-3e3ebb00-7628-11eb-8abe-1d677fd09a75.PNG">
<br/>
1-5. 댓글등록5  
<img width="877" alt="댓글등록5" src="https://user-images.githubusercontent.com/47100164/108852164-983f8080-7628-11eb-8cc1-990494b920ec.PNG">

> 게시글로 들어간 후 댓글쓰기를 클릭한다(1-1)
> 
> 댓글쓰기를 누르면 Modal창이 뜬다(1-2)
> 
> Modal창에 Reply와 Replyer를 입력한다.(1-3)
> 
> 후 등록버튼을 클릭하면 alert창이 뜨면서 댓글입력성공을 알려준다.(1-4)
> 
> 게시글 하단 댓글창에 댓글입력된 것을 확인할 수 있다.(1-5)

<br/>

2-1. 댓글수정/삭제
<img width="877" alt="댓글수정/삭제1" src="https://user-images.githubusercontent.com/47100164/108852164-983f8080-7628-11eb-8cc1-990494b920ec.PNG">

<br/>

2-2. 댓글수정/삭제
<img width="877" alt="댓글수정/삭제2" src="https://user-images.githubusercontent.com/47100164/108852765-595dfa80-7629-11eb-9d51-f957c16a93c1.PNG">

<br/>

2-3. 댓글수정/삭제
<img width="877" alt="댓글수정/삭제3" src="https://user-images.githubusercontent.com/47100164/108852954-87dbd580-7629-11eb-9ac2-05dba20e2e25.PNG">

 
> 게시글에 등록된 댓글을 클릭한다(2-1)
> 
> Reply-Modal창에서 수정/삭제을 확인할 수 있다.(2-2)
> 
> Reply자체는 수정이 되고 Replyer은 Read-only상태여서 수정불가 / 삭제를 누르면 댓글이 삭제된다(2-3)




<br/>
<br/>
<br/>
<br/>

<h3 align="center"><strong> 파일 업로드 </strong></h3>

1. 파일업로드
<img width="877" alt="파일업로드" src="https://user-images.githubusercontent.com/47100164/108860014-26b80000-7631-11eb-83e3-b9ad9123ce37.PNG">

> 게시글에 등록 시 파일선택을 클릭하여 파일/사진을 등록할 수 있다.
> 
> 사진은 썸네일로 표시되고 파일은 미리 지정해 놓은 사진으로 표시된다.



<br/>
<br/>
2. 업로드파일삭제
<img width="877" alt="업로드파일삭제" src="https://user-images.githubusercontent.com/47100164/108860292-68e14180-7631-11eb-8a1a-6b2ac25d6e1a.PNG">

> 파일이 등록되면 파일 옆에 'X' 표시가 생긴다.
> 
> 'X' 표시 클릭시 파일은 삭제된다.

<br/>
<br/>
3-1. 업로드파일(사진)확대
<img width="877" alt="업로드파일(사진)확대1" src="https://user-images.githubusercontent.com/47100164/108861292-67fcdf80-7632-11eb-9070-af26b2b83077.PNG">
3-2. 업로드파일(사진)확대
<img width="877" alt="업로드파일(사진)확대2" src="https://user-images.githubusercontent.com/47100164/108860672-c5446100-7631-11eb-8ef2-fb9b77385a6e.PNG">

> 파일/사진이 등록된 게시글에서 사진을 클릭하면
> 
> 사진이 확대되어서 보여진다.
> 
> 확대된 사진을 다시한번 클릭하면 점진적으로 축소된 후 사라진다.
<br/>
<br/>


