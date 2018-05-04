package edoardo.vcs.rtc;

import java.util.Optional;

/**
 * An entry point for performing every RTC related action.
 *
 * @author Edoardo Luppi
 */
public interface RtcManager {
	/**
	 * Creates a new Repository connection.
	 *
	 * @param uri
	 * 			The URI of the Repository connection
	 * @param userId
	 * 			The user ID for connecting to the Repository connection
	 * @param password
	 * 			The password associated to the user ID
	 * @param connectionTimeout
	 * 			The connection timeout in seconds. 0 for infinite (not recommended as it may hang forever)
	 * @return The created Repository connection
	 */
	RtcRepositoryConnection newRepositoryConnection(
				final String uri,
				final String userId,
				final String password,
				final int connectionTimeout);

	/**
	 * Creates a new Repository workspace.
	 *
	 * @param repositoryConnection
	 * 			The Repository connection to which the Repository workspace will belong to
	 * @param name
	 * 			The name of the Repository workspace
	 * @return The created Repository workspace
	 */
	RtcRepositoryWorkspace newRepositoryWorkspace(
				final RtcRepositoryConnection repositoryConnection,
				final String name);

	/**
	 * Creates a new Component.
	 *
	 * @param stream
	 * 			The Stream to which the Component will belong to
	 * @param name
	 * 			The name of the component
	 * @return The new Component
	 */
	RtcComponent newComponent(
				final RtcStream stream,
				final String name);

	/**
	 * Adds a Component to a Repository Workspace.
	 *
	 * @param repositoryWorkspace
	 * 			The Repository workspace that will receive the component
	 * @param component
	 * 			The Component to add
	 */
	void addComponent(
				final RtcRepositoryWorkspace repositoryWorkspace,
				final RtcComponent component);

	/**
	 * Adds a Component to a Stream.
	 *
	 * @param stream
	 * 			The Stream that will receive the component
	 * @param component
	 * 			The Component to add
	 */
	void addComponent(
				final RtcStream stream,
				final RtcComponent component);

	/**
	 * Set a Stream as Flow target for a Repository workspace.
	 *
	 * @param repositoryWorkspace
	 * 			The Repository workspace whose Flow target must be set
	 * @param flowTarget
	 * 			The Flow target
	 */
	void setRepositoryWorkspaceFlowTarget(
				final RtcRepositoryWorkspace repositoryWorkspace,
				final RtcStream flowTarget);

	/**
	 * Set another Repository workspace as Flow target for a Repository workspace.
	 *
	 * @param repositoryWorkspace
	 * 			The Repository workspace whose Flow target must be set
	 * @param flowTarget
	 * 			The Flow target
	 */
	void setRepositoryWorkspaceFlowTarget(
				final RtcRepositoryWorkspace repositoryWorkspace,
				final RtcRepositoryWorkspace flowTarget);

	/**
	 * Returns a Repository Connection via its unique ID.
	 *
	 * @param uid
	 * 			The unique ID of the Repository Connection
	 * @return The Repository Connection
	 */
	Optional<RtcRepositoryConnection> getRepositoryConnection(final String uid);

	/**
	 * Returns a Repository workspace via its unique ID.
	 *
	 * @param id
	 * 			The unique ID of the Repository workspace
	 * @return The Repository workspace
	 */
	Optional<RtcRepositoryWorkspace> getRepositoryWorkspace(final String id);
}
