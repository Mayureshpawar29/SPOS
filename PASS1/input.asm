	START	200
	MOVER 	AREG,='5'
	MOVEM	AREG,C
LOOP	MOVER	AREG,D
	MOVER	CREG,B
	ADD	CREG,='1'
	MOVER	DREG,A
	MOVER	CREG,B
	MOVER	AREG,A
	MOVER	CREG,B
	MOVER	AREG,A
	BC 	ANY,NEXT
	LTORG
	MOVER	AREG,A
NEXT	SUB	AREG,='1'
	BC	LT,BACK
LAST	STOP
	ORIGIN	LOOP+2
	MULT	CREG,B
	ORIGIN	LAST+1
A	DS	1
BACK	EQU	LOOP
B	DS	1
	END
