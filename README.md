# Functional Interface #

## Function Input T class -> Output R Class ##

Function

  Define the function <T,R> one Input, one output 
  
  Function.apply(T t)
  
  Function.andThen(...)
  <V> Function<T,V> andThen(Function <? super R, ? extends V after)
  
  Function.compose(...)
  <V> Function<V,R> compose(Function<? super V, ? extends T> before)
  
  Function.identity()
  static <T> Function<T,T> identity()

## Predicate Input T -> Output boolean ##

Predicate

## BiPredicate Input T, Input U -> Output boolean ##

BiPredicate

## UnaryOperator Input T class -> T class ##

UnaryOperator

## BinaryOperator Input T class, T class -> T class ##

BinaryOperator

## Supplier Input ---, Output T class ##

Supplier
   .get(): T

## Consumer Input T class, Output --- ##

Consumer
  .accept(T)
  .andThen( Consumer<? super T>): Consumer<T>

## BiConsumer Input T class, U class, Output --- ##

BiConsumer
  .accept(T)
  .andThen(Consumer<? super T> Consumer<? super U>): BiConsumer<T,U>
  


