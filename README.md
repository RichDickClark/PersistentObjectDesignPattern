# PersistentObjectDesignPattern
Ensure objects are in exactly one location at any given time - Prevents logic errors in your program

This design pattern ensures that an object is in exactly
one location (collection) at any given time.  Once an
object of the affected class has been placed in a
location it can only be removed from that location 
by placing it in another location.  This helps 
prevent programming errors which would result in an
object being in two places at once or in no location
at all.

Note that the guarantee that an object remains in 
exactly one location after being added to a location
rests upon the assumption that there are no classes
in the same package with the object and location classes.
Another class that had access to the protected members
of the object and location classes could duplicate 
objects or cause them to disappear.  