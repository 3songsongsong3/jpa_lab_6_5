package Entity;

import javax.persistence.*;

/**
 * 조인 전략
 * 엔티티 각각을 모두 테이블로 만들고 자식 테이블이 부모 테이블의 기본 키를 받아서
 * 기본 키 + 외래 키로 사용하는 전략.
 *
 * 객체는 타입으로 구분할 수 있지만 테이블은 타입의 개념이 없다.
 * 따라서 타입을 구분하는 컬럼을 추가해야 한다. -> DTYPE 컬럼을 구분 컬럼으로 사용한다.
 *
 * 장점
 *  1. 테이블이 정규화된다.
 *  2. 외래 키 참조 무결성 제약조건을 활용할 수 있다.
 *  3. 저장공간을 효율적으로 사용한다.
 *
 * 단점
 *  1. 조회할 때 조인이 많이 사용되어 성능이 저하될 수 있다.
 *  2. 데이터를 등록할 INSERT SQL을 두 번 실행한다.
 */
@Entity
// 상속 매핑은 부모 클래스에 해당 어노테이션 사용하고 매핑 전략을 지정해야한다.
@Inheritance(strategy = InheritanceType.JOINED)
// 부모 클래스에 구분 컬럼을 지정한다.
// 이 컬럼으로 자식 테이블을 구분할 수 있다.
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
