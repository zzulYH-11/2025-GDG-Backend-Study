1. 1주차 학습 내용
  https://velog.io/@jjulu0227/gdg-%EB%B0%B1%EC%95%A4%EB%93%9C-%EC%8A%A4%ED%84%B0%EB%94%94-1%EC%A3%BC%EC%B0%A8

2. Whitelabel Error Page Screenshot
   <img width="1680" height="1050" alt="Screenshot 2025-10-13 at 2 51 41 PM" src="https://github.com/user-attachments/assets/8faeb4ec-3fe4-415a-8585-18bec97ed5bb" />

3. 온라인 쇼핑몰 프로젝트 API 명세서 ( HTTP Method , URI )

   - 회원 기능
  
     - 이름, 전화번호, 주소를 바탕으로 회원 등록 -> Post , /members
     - 회원 리스트 조회 -> Get , /members
     - 회원 정보 상세 조회 -> Get , /members/{memberID}
     - 회원 정보 수정 -> Patch , /members/{memberID}
     - 회원 삭제 -> Delete , /members/{memberID}
  
   - 상품 기능
  
     - 상품 이름, 가격, 배송비, 배송일을 바탕으로 상품 등록 -> Post , /items
     - 상품 리스트 조회 -> Get , /items
     - 상품 정보 상세 조회 -> Get , /items
     - 상품 정보 수정 -> Patch , /items/{itemsID}
     - 상품 삭제 -> Delete , /items/{itemsID}
     - 관심 상품 장바구니 등록, 삭제 -> Post , Delete /items/{itemsID}
  
   - 주문 기능
  
     - 장바구니에 있는 상품 주문 -> Post , /items{itemsID}
     - 나의 주문 내역 조회 -> Get , /items
     - 배송일 조회 -> Get , /items/{itemsID}
     - 주문 취소 -> Delete , /items/{itemsID}

   
