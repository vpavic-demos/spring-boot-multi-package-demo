package co.sys.concept.adt.state.type.i;

import java.util.Optional;
import java.util.function.Function;

public abstract class Sum<A, B> {

	enum Type {
		LEFT,
		RIGHT
	}

	public abstract Type getType();

	public abstract <R> R either(Function<? super A, ? extends R> left, Function<? super B, ? extends R> right);

	protected Sum() {
	}


	public static <A, B> Sum<A, B> left(A value) {

		return new Sum<A, B>() {
			@Override
			public Type getType() {
				return Type.LEFT;
			}

			@Override
			public <R> R either(Function<? super A, ? extends R> left, Function<? super B, ? extends R> right) {
				return left.apply(value);
			}
		};
	}

	public static <A, B> Sum<A, B> right(B value) {
		return new Sum<A, B>() {
			@Override
			public Type getType() {
				return Type.RIGHT;
			}

			@Override
			public <R> R either(Function<? super A, ? extends R> left, Function<? super B, ? extends R> right) {
				return right.apply(value);
			}
		};
	}


	public Optional<A> fromLeft() {
		return this.either(Optional::of, val -> Optional.empty());
	}

	public Optional<B> fromRight() {
		return this.either(val -> Optional.empty(), Optional::of);
	}

	public Boolean isLeft() {
		return this.getType().equals(Type.LEFT);
	}

	public Boolean isRight() {
		return this.getType().equals(Type.RIGHT);
	}

}


