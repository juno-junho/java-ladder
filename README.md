# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항
- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 최대 사다리 높이를 입력 받는다.

## 출력
- [x] 사다리를 만든다
  - ladder 생성자 -> 정적 팩토리 메서드 변경

  - [x] 입력받은 사다리 높이 만큼 만든다.
  - [x] 각 라인에서 사다리를 가질 수도 있고 안 가질 수도 있다 -> `Random`을 이용해서 만든다.
  - [x] Line 객체를 만든다. -> `Boolean' arrayList를 가지고 있다.
    - [x] 겹치는 가로 라인이 있을 없게끔 하기.
      - Line 클래스에서 리스트의 이전 값을 확인해줘야함.
      - 모두 랜덤 값으로 설정해 놓고 이전 값이 true이면 다음 값만 false로 변환하기.
   
- 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. -> 정확히 무슨말인지 이해 못하겠음.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다. (사다리가 있거나 없거나 random값 사용하기) 
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 실행 결과
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk 
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```
- 실행결과 이름 출력 시 5글자 기준으로 출력. 글자 간 공백 1칸. (공백 + 5-글자수 공백)

## 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
---

## Step 3 기능 목록
- [x] 실행 결과 입력받기
  - [x] 쉼표를 기준으로 결과 구분하여 나누기 -> `Result` 클래스 생성 고려해보기
  - [x] 참여자 수와 결과 수가 일치 해야한다
    - [x] 일치하지 않으면 예외 발생하기
- [x] 출력 결과는 사다리가 출력 되고 `OutputView`의 이름 출력 로직과 동일한 방식 사용
- [x] 결과 보고 싶은 사람 입력 받기
  - [x] participant에 포함 되거나, all이 아닐 경우 예외 발생하기

  
- [x] 이름에 해당하는 결과값을 매칭한다
  - [x] Map에 participants의 list를 각각 key로 등록한다.
  - [x] list의 index가 있을때 index -1 , index에 해당하는 값을 사다리 list에서 값을 찾는다.
    - [x] index가 true이면 index ++
    - [x] index -1 이 true이면 index --
    - [x] false면 그냥 index 유지
- all 입력하거나 지난 번 호출 했을 경우 caching 하기

- [x] 사다리 실행 결과 출력
  - [x] 개인별 이름 입력시 개인별 결과를 출력한다.

  - [x] `all` 입력 시 전체 참여자의 실행 결과 출력
    - Map 사용 고려해보기 -> x
  
- [x] 테스트 리펙토링
- [x] 전체적인 리펙토링

## Step 3 리뷰 후 피드백을 통한 변경 사항

- Ladder 클래스에서 List<Line> 을 가지는 일급 컬렉션으로 변경
- 사다리 타기 결과 계산 또한 Ladder 클래스에서 구현
  - 결과 계산 시 모든 결과를 다 만들어 놓고 이름 입력 받으면 그 해당 값만 반환하기.


## Step 3 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

## Step 4 요구사항에 따른 기능 목록
- In -> Out 방식으로 TDD를 도전한다.
- Point 클래스 분리 -> 최대한 작은 객체 Point 부터 확장해 나가기
- [x] Point 객체 분리
  - Point는 previous, current boolean 값 가진 Direction과 index를 연결.
  - [x] Direction 객체 분리
    - Direction에서 strategy 따라 boolean 값 생성.
- NextStepLineCreator : List<Point>를 생성해야함
  - Point는 각 index를 가지고 있으며 각 index에 따라서 direction을 생성해야함..
  - Direction 생성할 때, previous, current를 각 index 마다 생성한다. 
    - 이때, random 값을 통해 생성, previous가 true -> current는 false로 고정.
    - 그리고 0번 index의 previous, 마지막 index의 current는 모두 false로 설정.
    - 
```
전체적인 로직은 다음과 같다.
index를 받는다. index가 n개이면 한 line에 point 개수는 n-1개 이다.
-> 처음이면 (index == 0) ->  0번 Point인 boolean 값만 확인해서 방향을 결정한다.
-> 마지막이면 (index == n ) -> n-1번 Point인 boolean 값만 확인해서 방향을 결정한다.
-> 처음과 마지막이 아니라면 
    index == n 일때, n-1, n번 Point를 비교해서 방향을 결정한다.
    n-1 번째 boolean 값을 left, n 번째 boolean 값을 right 라고 하면, 
    true  false -> index-- : 왼쪽으로 이동
    false true  -> index++ : 오른쪽으로 이동
    false false -> index 유지 : index 유지해서 그다음 line으로 이동
    true  true  -> 예외 발생
    
 -> 전체적으로 평가했을때, Point는 index를 받아 이후 결과 계산을 통해 이후 index를 반환해 줘야 한다.
 
 index가 0 (처음)이면 previous의 값과 무관하게 current 값으로만 이동한다. -> previous 값을 가질 수 없다.
 index가 n (마지막)이면 current의 값과 무관하게 previous 값으로만 이동한다 -> current 값을 가질 수 없다.
 -> parameter 분리를 위해서 Direction 객체를 생성한다.
 
 - Point는 index를 받아 Direction을 통해서 index를 계산한다.
 
 
```

  - Point는 2개의 boolean 값을 가지고 있다. left, current
  - 그런데 처음 index일 경우는 


- 책임주도설계 방식으로 책임에 따라 인터페이스 분리
  - 역할
    - [x] 사다리 생성하기 -> 참여자와 Height를 가지고 있다. -> LadderCreator
    - [x] 사다리 실행을 통해 결과 얻기 -> Ladder
    - [x] Line 객체 생성 -> LineCreator
    - [x] Line에서 index를 받아 결과 index를 계산 -> Line