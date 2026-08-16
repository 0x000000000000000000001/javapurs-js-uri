module TestHex where
import Prelude
import Data.Char as Char
import Data.Int as Int
import Data.String as String

test = Int.toStringAs Int.hexadecimal (Char.toCharCode 'a')
