
@PostMapping(value="/member")
public class MemberCreationResponse createMember{
    @valid @RequestBody final MemberCreationRequest memberCreationRequest){
    // member creaion logics here...
    }
}
